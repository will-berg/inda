package main

import "golang.org/x/tour/pic"

func Pic(dx, dy int) [][]uint8 {
	s := make([][]uint8, dy)
	for i := 0; i < dy; i++ {
		s[i] = make([]uint8, dx)
	}
	for i := 0; i < dy; i++ {
		for j := 0; j < dx; j++ {
			switch {
			case i > 105 && i < 145:
				s[i][j] = 255
			case j > 105 && j < 145:
				s[i][j] = 255 
			default: 
				s[i][j] = 4
			}
		}
	}
	return s
}

func main() {
	pic.Show(Pic)
}
