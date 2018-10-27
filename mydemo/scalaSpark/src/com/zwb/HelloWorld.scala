package com.zwb

object HelloWorld {
  def main(args: Array[String]): Unit = {
    val a:Boolean = false
    println(a)

    val s = "hello world123";
    for(c <- s){
      println(c)
    }

    val arr = Array(1,2,3,4,5,6)
    for(a <- arr){
      println(a)
    }

    for(i <- 1 to 3;j <- 1 to 3 if(i!=j)){
      println(i*10+j)
    }

    val v = for(i <- 1 to 10) yield i * 10
    println(v)

    val v2 = (1 to 10).map(_ * 100)
    println(v2)

    for(i <- 0 until 4)println(i)

    val x = 2
    val y = if(x > 10) x else "不大于10"
    println(y)
    var m = if(x > 2) 1 else if (x == 2) 2 else 3
    println(m)
    //+是一个方法
    val o = 1.+(10)
    println(o)

    //定义一个方法
    def pf(x : Int):Int = x*x
    println(pf(5))

    def pf1(x : Int) = x*x
    println(pf1(6))

    def n(x:Int,y:Int) : Unit = println(x+y)
    n(1,2)

    def f(x:Int) : Int ={
      if(x>0){
        println(f(x-1))
      }
      return x;
    }

    f(10)
  }
}
