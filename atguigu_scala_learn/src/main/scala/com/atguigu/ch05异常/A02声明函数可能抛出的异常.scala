package com.atguigu.ch05异常

object A02声明函数可能抛出的异常 {
  def main(args: Array[String]): Unit = {
    try
      test()
    catch {
      case e: Exception=>e.printStackTrace()
    }

    println("----------------")
  }

  @throws(classOf[Exception])
  def test():Nothing={
    throw new Exception("test")
  }
}
