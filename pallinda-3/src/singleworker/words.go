package main

import (
	"fmt"
	"io/ioutil"
	"strings"
	"time"
)

// DataFile is the txt document we are testing.
const DataFile = "loremipsum.txt"

// WordCount returns the word frequencies of the text argument.
func WordCount(text string) map[string]int {
	// Convert all strings to lower case and remove punctuation.
	text = strings.ToLower(text)
	text = strings.ReplaceAll(text, ".", "")
	text = strings.ReplaceAll(text, ",", "")

	freqs := make(map[string]int)

	words := strings.Fields(text)
	for _, word := range words {
		// Increment the value.
		freqs[word] = freqs[word] + 1
	}
	return freqs
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
