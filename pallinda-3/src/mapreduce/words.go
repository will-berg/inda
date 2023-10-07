package main

import (
	"fmt"
	"io/ioutil"
	"strings"
	"time"
)

// DataFile is the txt document we are testing.
const DataFile = "loremipsum.txt"

// Set number of goroutines.
const numGoroutines = 300

// WordCount returns the word frequencies of the text argument.
func WordCount(text string) map[string]int {
	// Convert all strings to lower case and remove punctuation.
	text = strings.ToLower(text)
	text = strings.ReplaceAll(text, ".", "")
	text = strings.ReplaceAll(text, ",", "")

	freqs := make(map[string]int)
	mapChan := make(chan map[string]int)
	// Create array of the words in text.
	words := strings.Fields(text)

	slices := split(words)

	// Launch goroutines for each slice of words in the slices array.
	for i := 0; i < numGoroutines; i++ {
		// Creates a map for each slice of words and sends them on the channel.
		go count(slices[i], mapChan)
	}
	// Combine the values of all the maps.
	freqs = combine(mapChan)
	return freqs
}

// Creates a map for given slice of words and sends it on the channel.
func count(words []string, mapChan chan<- map[string]int) {
	freqs := make(map[string]int)
	for _, word := range words {
		// Increment the value.
		freqs[word] = freqs[word] + 1
	}
	// Send the map on the channel.
	mapChan <- freqs
}

// Receives maps from the channel and combines values into one final result map that is returned.
func combine(mapChan <-chan map[string]int) map[string]int {
	resultMap := make(map[string]int)
	// Receive maps from all the goroutines and add it all up.
	for i := 0; i < numGoroutines; i++ {
		m := <-mapChan
		for key, value := range m {
			// Add the values of the keys in the maps sent over the channel.
			resultMap[key] = resultMap[key] + value
		}
	}
	return resultMap
}

// Split words array into slices and return an array of those slices.
func split(words []string) [][]string {
	var slices [][]string
	var sliceSize int = (len(words) + numGoroutines) / numGoroutines
	for i := 0; i < len(words); i = i + sliceSize {
		// Set lower and upper bound for the slice.
		lo := i
		hi := i + sliceSize
		// Set the upper bound to the max if it exceeds it.
		if hi > len(words) {
			hi = len(words)
		}
		// Add a new slice between lo and hi to the slices array.
		s := words[lo:hi]
		slices = append(slices, s)
	}
	return slices
}

// Benchmark how long it takes to count word frequencies in text numRuns times.
//
// Return the total time elapsed.
func benchmark(text string, numRuns int) int64 {
	start := time.Now()
	for i := 0; i < numRuns; i++ {
		WordCount(text)
	}
	runtimeMillis := time.Since(start).Nanoseconds() / 1e6

	return runtimeMillis
}

// Print the results of a benchmark
func printResults(runtimeMillis int64, numRuns int) {
	fmt.Println()
	fmt.Printf("amount of runs: %d\n", numRuns)
	fmt.Printf("total time: %d ms\n", runtimeMillis)
	average := float64(runtimeMillis) / float64(numRuns)
	fmt.Printf("average time/run: %.2f ms\n", average)
}

func main() {
	// read in DataFile as a string called data
	byte, _ := ioutil.ReadFile(DataFile)
	data := string(byte)

	fmt.Printf("%#v", WordCount(string(data)))

	numRuns := 100
	runtimeMillis := benchmark(string(data), numRuns)
	printResults(runtimeMillis, numRuns)
}
