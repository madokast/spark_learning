package com.sekai

object HelloWorld {
  def main(args:Array[String]):Unit={
    println("Hello, world!")
    println(sayHello())
    var fun = (x:Int) => x+1
    println(fun(10))
  }

  def sayHello():String="Hello"
}
