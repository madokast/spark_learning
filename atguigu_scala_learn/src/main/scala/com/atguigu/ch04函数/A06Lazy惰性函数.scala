package com.atguigu.ch04函数

object A06Lazy惰性函数 {
  def main(args: Array[String]): Unit = {
    val a = sum(1,2)
    println("------------")
    println(a)


    lazy val b = sum(10,20)
//    println(b.getClass)
    println("------------")
    println(a)
  }

  def sum(a:Int,b:Int)={
    println(s"run sum $a + $b")
    a+b
  }
}
