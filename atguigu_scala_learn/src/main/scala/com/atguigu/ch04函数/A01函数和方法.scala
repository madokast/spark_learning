package com.atguigu.ch04函数

object A01函数和方法 {
  def main(args: Array[String]): Unit = {
    val a = new A()
    println(a.sum(1, 2))

    val funSum = a.sum _
    println(funSum(3, 4))

    val funSum2 = (a: Int, b: Int) => a + b
    println(funSum2(5, 6))


  }
}

class A {
  def sum(a: Int, b: Int) = a + b
}
