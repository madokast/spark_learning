package com.atguigu.ch01

/**
 * 等价于 HelloWorld 的静态对象，单例
 *
 */
object A02ForLoop {
  def main(args: Array[String]): Unit = {
    val arr:Array[Int] = new Array[Int](5)
    println(arr.length)
    for (elem <- arr) {
      println(elem)
    }
  }
}
