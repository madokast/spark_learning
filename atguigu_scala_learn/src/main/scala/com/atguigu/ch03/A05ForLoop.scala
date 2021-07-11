package com.atguigu.ch03

object A05ForLoop {
  def main(args: Array[String]): Unit = {
    this.for1
    this.for2

    val what = 1.to(3)
    println(what)
    println(what.getClass)
  }

  def for1: Unit = {
    for (i <- 1 to 3) {
      println(i)
    }
  }

  def for2: Unit ={
    for(i<- 0.until(3)){
      println(i)
    }
  }
}
