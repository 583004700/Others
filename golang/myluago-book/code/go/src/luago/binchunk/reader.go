package binchunk

import (
	"encoding/binary"
	"math"
)

type reader struct {
	data []byte
}

//向后读取一个字节
func (self *reader) readByte() byte {
	b := self.data[0]
	self.data = self.data[1:]
	return b
}

//读取n个字节
func (self *reader) readBytes(n uint) []byte {
	bytes := self.data[:n]
	self.data = self.data[n:]
	return bytes
}

//通过小端编码的方法读取4个字节形成一个uint32类型
func (self *reader) readUint32() uint32 {
	i := binary.LittleEndian.Uint32(self.data)
	self.data = self.data[4:]
	return i
}

//通过小端编码的方法读取8个字节形成一个uint64类型
func (self *reader) readUint64() uint64 {
	i := binary.LittleEndian.Uint64(self.data)
	self.data = self.data[8:]
	return i
}

//读取lua integer类型
func (self *reader) readLuaInteger() int64 {
	i := int64(self.readUint64())
	return i
}

//读取lua number类型
func (self *reader) readLuaNumber() float64 {
	return math.Float64frombits(self.readUint64())
}
