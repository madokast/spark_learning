package com.atguigu.ch03

object A08循环到数组 {
  def main(args: Array[String]): Unit = {
    val ret = for (i <- 0 to 10) yield i * i
    println(ret)
    println(ret.getClass)

    val ret2 = for (i <- 0 to 10 if i % 3 != 0) yield {
      if (i % 2 == 0) {
        i
      }
    }
    println(ret2)
  }
}
