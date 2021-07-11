package com.atguigu.ch03

object A14While {
  def main(args: Array[String]): Unit = {
    var i = 0
    while (i < 5) {
      print(i)
      i += 1
    }
    println()
    i = 0
    do {
      print(i)
      i += 1
    } while (i < 10)
  }
}
