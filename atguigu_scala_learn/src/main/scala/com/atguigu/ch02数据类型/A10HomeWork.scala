package com.atguigu.ch02数据类型

import java.math.BigInteger

object A10HomeWork {
  def main(args: Array[String]): Unit = {
    println("abc" * 3)

    val TWO:BigInt = new BigInt(BigInteger.valueOf(2))
    println(TWO.pow(1021))

    val num:Num = new Num(3)
    println(num)
    println(num*10)

    println(10 max 2)

    println("hello".take(3))
  }
}

class Num {
  var value: Int = _

  def this(num:Int) = {
    this()
    this.value = num
  }

  def *(a: Int): Int = value * a

  override def toString: String = value.toString


}
