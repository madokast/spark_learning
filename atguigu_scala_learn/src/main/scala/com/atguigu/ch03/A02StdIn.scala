package com.atguigu.ch03

import scala.io.StdIn

/**
 * 输入
 */
object A02StdIn {
  def main(args: Array[String]): Unit = {
    println("请输入：")
    val name: String = StdIn.readLine()
    println(s"输入的是 $name")
  }
}
