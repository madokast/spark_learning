package com.atguigu.ch03

object A01运算符 {
  def main(args: Array[String]): Unit = {
    println(10 / 3)
    println(10 % 3)

    val num = math.random()
    val a = if (num>0.5) "a" else 3.0

    println(a)

    val + = 100
    println(+)
  }
}
