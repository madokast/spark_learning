package com.atguigu.ch06面向对象

object A02Foreach {
  def main(args: Array[String]): Unit = {
    var r = 1L
    "Hello".foreach(r *= _.toLong)
    println(r)

    val whatis: Char => Unit = (r *= _.toLong)
    println(whatis)
    println(whatis(1))
  }
}
