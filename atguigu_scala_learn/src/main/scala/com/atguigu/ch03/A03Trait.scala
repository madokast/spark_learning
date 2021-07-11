package com.atguigu.ch03

object A03Trait {
  def main(args: Array[String]): Unit = {
    val cat = new Cat()
    cat.fly()

    DefaultCat.fly()
  }
}

trait FlyAble {
  def fly(): Unit = println("飞飞飞")
}

class Cat extends FlyAble {

}

object DefaultCat extends FlyAble {

}