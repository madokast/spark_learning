package com.atguigu.ch02数据类型

/**
 * 变量
 * 2021年5月27日
 */
object A04变量 {
  def main(args: Array[String]): Unit = {
    println("变量")

    var a: Int = 1
    val b: Int = 2
    println(a)
    println(b)

    val name: String = "Tom"
    val ch: Char = 'a'
    println(name)
    println(ch)

    val price: Double = 10.9
    println(price)

    val age = 10
    println(age.getClass)

    println(name.map(c => c))

    print(name.isInstanceOf[String])
  }
}
