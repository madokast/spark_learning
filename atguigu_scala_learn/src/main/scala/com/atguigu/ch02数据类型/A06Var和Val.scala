package com.atguigu.ch02数据类型

object A06Var和Val {
  def main(args: Array[String]): Unit = {
    var age = 10
    age = 20
    println(age)

    val A = 1
    //    A=2
    // 报错
    // reassignment to val
    //    A=2

    println(A)
  }
}
