package com.atguigu.ch01

/**
 * 等价于 HelloWorld 的静态对象，单例
 *
 */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, World")
    val num:Int = 1
    println(s"$num")
  }
}
