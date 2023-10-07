package main

import "fmt"

// Sum the numbers in a and send the result on res.
func sum(a []int, res chan<- int) {
	// TODO sum a
	elementSum := 0
	for _, value := range a {
		elementSum += value
	}
	// Send result on res
	res <- elementSum
}

// ConcurrentSum the array a.
func ConcurrentSum(a []int) int {
	n := len(a)
	ch := make(chan int)
	go sum(a[:n/2], ch)
	go sum(a[n/2:], ch)
	// Get the subtotals from the channel and return their sum
	subtotal1 := <-ch
	subtotal2 := <-ch
	return subtotal1 + subtotal2
}

func main() {
	// example call
	a := []int{1, 2, 3, 4, 5, 6, 7}
	fmt.Println(ConcurrentSum(a))
}
