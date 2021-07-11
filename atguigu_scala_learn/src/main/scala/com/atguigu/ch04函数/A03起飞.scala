package com.atguigu.ch04函数

object A03起飞 {
  def main(args: Array[String]): Unit = {
    val a = new A03()
    val fun = a.high()
    println(fun())
    println(fun())
    println(fun())
  }
}

class A03 {
  def high() = {
    var a: Int = 3
    () => {
      a+=1
      println(System.identityHashCode(a))
      a
    }
  }
}
