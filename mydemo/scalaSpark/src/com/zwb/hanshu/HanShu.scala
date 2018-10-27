package com.zwb.hanshu

object HanShu {
  def main(args: Array[String]): Unit = {
    //定义一个函数，函数可以当作参数
    var f = (x:Int) => x*10
    println(f(10))

    var arr = Array(1,2,3,4,5)
    var newArr = arr.map(_*10).map(x => println(x))

    def ttt(f:Int => Int): Unit ={
      println(f(100))
    }

    var f0 = (x:Int) => x*2
    def f1(i:Int) = i*i

    ttt(f0)

    ttt(f1)
  }
}
