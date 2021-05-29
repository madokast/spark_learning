package com.atguigu.ch02数据类型

object A05Scala是静态语言 {
  def main(args: Array[String]): Unit = {
    var age = 10
    println(age)

    //    age = 1.1
    // 编译错误
    // type mismatch;
    // found   : Double(1.1)
    // required: Int
    //    age = 1.1
    println(age)
  }
}
