// Stefan Nilsson 2013-03-13

// This is a testbed to help you understand channels better.
package main

import (
	"fmt"
	"math/rand"
	"strconv"
	"sync"
	"time"
)

var wgProducer sync.WaitGroup
var wgConsumer sync.WaitGroup

func main() {
	// Use different random numbers each time this program is executed.
	rand.Seed(time.Now().Unix())

	const strings = 32
	const producers = 4
	const consumers = 2

	before := time.Now()
	ch := make(chan string)
	wgProducer.Add(producers)
	wgConsumer.Add(consumers)
	for i := 0; i < producers; i++ {
		go Produce("p"+strconv.Itoa(i), strings/producers, ch)
	}
	for i := 0; i < consumers; i++ {
		go Consume("c"+strconv.Itoa(i), ch)
	}
	wgProducer.Wait()
	close(ch)
	wgConsumer.Wait()
	fmt.Println("time:", time.Now().Sub(before))
}

// Produce sends n different strings on the channel and notifies wg when done.
// sending goroutine
func Produce(id string, n int, ch chan<- string) {
	for i := 0; i < n; i++ {
		RandomSleep(100) // Simulate time to produce data.
		ch <- id + ":" + strconv.Itoa(i)
	}
	wgProducer.Done()
}

// Consume prints strings received from the channel until the channel is closed.
// receiving goroutine
func Consume(id string, ch <-chan string) {
	for s := range ch {
		fmt.Println(id, "received", s)
		RandomSleep(100) // Simulate time to consume data.
	}
	wgConsumer.Done()
}

// RandomSleep waits for x ms, where x is a random number, 0 â‰¤ x < n,
// and then returns.
func RandomSleep(n int) {
	time.Sleep(time.Duration(rand.Intn(n)) * time.Millisecond)
}
