package com.atguigu.ch02数据类型

object A12强制类型转换 {
  def main(args: Array[String]): Unit = {
    println(2.0.toInt)

    println(3.9.toInt)

    val ageStr:String = "16" // 底层就是 parseXXX
    val age:Int = ageStr.toInt
    println(age)
  }
}
