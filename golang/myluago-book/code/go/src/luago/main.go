package main

import (
	"fmt"
)

func main() {
	bytes := []byte{1, 2, 3, 4, 5, 6}
	var h = bytes[:3]
	fmt.Println(h)
	var h1 = bytes[0:3]
	fmt.Println(h1)
	var i = 0xFF
	fmt.Println(i)
}
