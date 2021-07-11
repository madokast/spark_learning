package com.atguigu.ch06面向对象

object A02Method {
  def main(args: Array[String]): Unit = {
    val a = new A02Method_
    println(a.cal(1, 2))
  }
}

class A02Method_ extends Cloneable {
  def cal(a: Int, b: Int): Int = {
    println(this)
    return a + b
  }

  def cal2(a: Int, b: Int) = a + b

  override def toString: String = "A02Method_"

  override def hashCode(): Int = super.hashCode()

  override def equals(obj: Any): Boolean = super.equals(obj)

  override def finalize(): Unit = super.finalize()

  override def clone(): AnyRef = super.clone()

}
