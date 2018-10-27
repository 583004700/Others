package com.zwb.four

import scala.collection.mutable.ArrayBuffer

object Test {

  def main(args: Array[String]): Unit = {
    val arr = Array(1,7,5,3,8,2,4,9)
    var newArr = arr.sortWith(_>_)
    println(newArr.toBuffer)

    val ar = new Array[Int](8)
    println(ar.toBuffer)

    val ab = ArrayBuffer[Int]()
    ab += 5
    ab += (1,3,7)
    ab.insert(1,-1,-2)
    ab.remove(0,2)
    val s = ab.reduce(_+_)
    println(ab.toBuffer)
    println(s)

    val m = Map("a" -> 1,"b" -> 2)
    println(m("b"))

    //元组
    val t = ("hadoop",1,2)
    println(t._1)
    println(t._2)
    println(t._3)

    //arr.par转为并行集合处理
    val sum = arr.par.reduce(_+_);
    println(sum)

    //并发执行初始值会被多次使用
    val sum1 = arr.par.fold(10)(_+_);
    println(sum1)
  }

}
