package com.atguigu.ch03

/**
 * 分支控制
 */
object A04IfElse {
  def main(args: Array[String]): Unit = {
    A04IfElse.ifElse()
    this.ifElse()
    this.isElse2()

    var a = 10
    var b = 9
    val ret = if(true) a=11 else 11
    println(ret)
  }

  def ifElse(): Unit = {
    if (10 > 2) {
      println("10>2")
    }
  }

  def isElse2(): Unit = {
    if (10 < 2) {
      println(1)
    } else {
      println(2)
    }
  }
}
