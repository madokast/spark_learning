package com.atguigu.ch05异常

object A01异常 {
  def main(args: Array[String]): Unit = {
    try {
      val a = 1 / 0
    } catch {
      case e: ArithmeticException => e.printStackTrace()
    } finally {
      println("------------------")
    }
  }
}
