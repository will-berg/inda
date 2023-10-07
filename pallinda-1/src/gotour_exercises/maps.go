package main

import (
	"strings"
	"golang.org/x/tour/wc"
)

func WordCount(s string) map[string]int {
	m := make(map[string]int)
	slice := strings.Fields(s)
	for i := 0; i < len(slice); i++ {
		m[slice[i]]++
	}
	return m
}
	
func main() {
	wc.Test(WordCount)
}
