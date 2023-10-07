package main

import (
	"fmt"
	"time"
)

func remind(text string, delay time.Duration) {
	const layout = "15.04.05"
	for {
		fmt.Println("The time is:", time.Now().Format(layout), text)
		time.Sleep(delay)
		fmt.Println("The time is:", time.Now().Format(layout), text)
		time.Sleep(delay)
		fmt.Println("The time is:", time.Now().Format(layout), text)
		time.Sleep(delay)
	}
}

func main() {
	go remind(": Time to eat", 10*time.Second)
	go remind(": Time to work", 30*time.Second)
	remind(": Time to sleep", 60*time.Second)
}
