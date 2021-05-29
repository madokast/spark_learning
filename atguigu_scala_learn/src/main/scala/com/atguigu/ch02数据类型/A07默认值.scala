package com.atguigu.ch02数据类型

object A07默认值 {
  def main(args: Array[String]): Unit = {
    val dog = new Dog
    println(dog.age)
    println(dog.name)
  }
}

class Dog {
  var age:Int = _
  var name:String = _
}
