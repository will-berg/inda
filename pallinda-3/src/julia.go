// Stefan Nilsson 2013-02-27

// This program creates pictures of Julia sets (en.wikipedia.org/wiki/Julia_set).
package main

import (
	"fmt"
	"image"
	"image/color"
	"image/png"
	"log"
	"math/cmplx"
	"os"
	"strconv"
	"sync"
	"time"
)

type ComplexFunc func(complex128) complex128

// Funcs = array of functions
var Funcs []ComplexFunc = []ComplexFunc{
	func(z complex128) complex128 { return z*z - 0.61803398875 },
	func(z complex128) complex128 { return z*z + complex(0, 1) },
	func(z complex128) complex128 { return z*z + complex(-0.835, -0.2321) },
	func(z complex128) complex128 { return z*z + complex(0.45, 0.1428) },
	func(z complex128) complex128 { return z*z*z + 0.400 },
	func(z complex128) complex128 { return cmplx.Exp(z*z*z) - 0.621 },
	func(z complex128) complex128 { return (z*z+z)/cmplx.Log(z) + complex(0.268, 0.060) },
	func(z complex128) complex128 { return cmplx.Sqrt(cmplx.Sinh(z*z)) + complex(0.065, 0.122) },
}

var wg sync.WaitGroup
var wgp sync.WaitGroup

func main() {
	//runtime.GOMAXPROCS(6)
	start := time.Now()

	wg.Add(8)
	for n, fn := range Funcs {
		// Create 8 png images named picture-n.png based on the functions fn of size 1024x1024.
		go CreatePng("picture-"+strconv.Itoa(n)+".png", fn, 1024)
	}
	wg.Wait()

	elapsed := time.Since(start)
	fmt.Println(elapsed)
}

// CreatePng creates a PNG picture file with a Julia image of size n x n.
func CreatePng(filename string, f ComplexFunc, n int) (err error) {
	file, err := os.Create(filename)
	if err != nil {
		return
	}
	defer file.Close()
	err = png.Encode(file, Julia(f, n))
	if err != nil {
		log.Fatal(err)
	}
	wg.Done()
	return
}

// Julia returns an image of size n x n of the Julia set for f.
func Julia(f ComplexFunc, n int) image.Image {
	bounds := image.Rect(-n/2, -n/2, n/2, n/2)
	img := image.NewRGBA(bounds)
	s := float64(n / 4)
	for i := bounds.Min.X; i < bounds.Max.X; i++ {
		wgp.Add(1)
		go func(i int) {
			for j := bounds.Min.Y; j < bounds.Max.Y; j++ {
				n := Iterate(f, complex(float64(i)/s, float64(j)/s), 256)
				r := uint8(0)
				g := uint8(0)
				b := uint8(n % 32 * 8)
				img.Set(i, j, color.RGBA{r, g, b, 255})
			}
			wgp.Done()
		}(i)
	}
	wgp.Wait()
	return img
}

// Iterate sets z_0 = z, and repeatedly computes z_n = f(z_{n-1}), n â‰¥ 1,
// until |z_n| > 2  or n = max and returns this n.
func Iterate(f ComplexFunc, z complex128, max int) (n int) {
	for ; n < max; n++ {
		if real(z)*real(z)+imag(z)*imag(z) > 4 {
			break
		}
		z = f(z)
	}
	return
}
