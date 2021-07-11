package com.atguigu.ch04函数

object A05可变参数 {
  def main(args: Array[String]): Unit = {
    println(sum())
    println(sum(1,2,3))

    def a = new A05_
    println(a.getClass)
    println(a.getClass)
    println(a.getClass)
  }

  def sum(numbers:Int*):Int={
    var s = 0
    for(num <- numbers)
      s+=num

    s
  }
}

class A05_{
  println(123)
}

