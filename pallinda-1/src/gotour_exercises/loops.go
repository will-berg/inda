package main

import (
	"fmt"
	"math"
)

func sqrt(x float64) float64 {
	z := 1.0
	for math.Abs(z*z-x) > 0.001 {
		z -= (z*z - x) / (2 * z)
		fmt.Println(z)
	}
	return z
}

func main() {
	fmt.Println(sqrt(2))
	fmt.Println()
	fmt.Println(math.Sqrt(2))
}
