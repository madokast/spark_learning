package com.atguigu.ch02数据类型

object A11ApplyMethod {
  def main(args: Array[String]): Unit = {
    val p: Person = new Person

    p()

    A()
  }
}

object A {
  def apply(): Unit = println("from object A")
}

class Person {
  def apply(): Unit = println("from apply")
}
