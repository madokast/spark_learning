package com.atguigu.ch03

import scala.util.control.Breaks._

object A16BreakContinue {
  def main(args: Array[String]): Unit = {
    println("break")
    println("continue")
    var a = 10

    codeBlock {
      var temp = 100
      temp = 10
      a += temp
      println(a)
    }

    breakable {
      var a = 0
      while (a < 10) {
        println(a)
        a += 1
        if (a == 4)
          break()
      }
    }
  }

  def codeBlock(op: => Unit): Unit = {
    println("----------------------------")
    println(op.getClass)
    println(op)
    op
    println("----------------------------")
  }
}
