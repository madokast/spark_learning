package com.atguigu.ch01

/**
 * 等价于 HelloWorld 的静态对象，单例
 *
 */
object A01HelloWorld {
  def main(args: Array[String]): Unit = {
    println("Hello, World")
    val num:Int = 12
    println(s"$num")
    val str:String = s"$num"
    println(str.length)
    println(str.charAt(0))
    println(str.charAt(1))

  }
}
