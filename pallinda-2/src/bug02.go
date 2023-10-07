package main

import (
	"fmt"
	"sync"
	"time"
)

var wg sync.WaitGroup

func main() {
	ch := make(chan int)
	wg.Add(2)
	go send(ch)
	go Print(ch)
	wg.Wait()
}

// Send only channel, sends numbers 1 through 11 on the channel
func send(ch chan<- int) {
	for i := 0; i <= 11; i++ {
		ch <- i
	}
	// No more elements to send over the channel, close the channel
	close(ch)
	wg.Done()
}

// Print all numbers sent on the channel
// Receive only.
func Print(ch <-chan int) {
	for n := range ch {
		time.Sleep(10 * time.Millisecond)
		fmt.Println(n)
	}
	wg.Done()
}
