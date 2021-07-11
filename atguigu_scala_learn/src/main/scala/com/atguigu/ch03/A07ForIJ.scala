package com.atguigu.ch03

/**
 * 嵌套循环
 */
object A07ForIJ {
  def main(args: Array[String]): Unit = {
    for (i <- 0 to 3; j <- 1 to i)
      println(s"$i $j")
  }
}
