package com.atguigu.ch02数据类型

import java.math.BigInteger

object A09NullAndNothing {
  def main(args: Array[String]): Unit = {

    // Unit
    val age: AnyVal = ()
    println(age)
    println(age.isInstanceOf[Unit])

    println(().getClass)

    // -------------
    println("---------------")
    println(returnUnit)
    println(returnNull)
    var a: Any = 1
    try {
      println(a)
      a = returnNothing
    } catch {
      case e: Exception => {
        println(e)
      }
    }
    println(a)
  }

  def returnUnit: Unit = ()

  def returnNull: Null = null

  def returnNothing: Nothing = throw new NullPointerException
}
