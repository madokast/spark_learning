package com.atguigu.ch03

object A05ForNewVar {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 3; j = 4 - i)
      println(s"$i $j")
  }
}
