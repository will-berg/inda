package main

import "fmt"

func main() {
	ch := make(chan string)
	go func() {
		ch <- "Hello world!"
	}()
	s := <-ch
	fmt.Println(s)
}
