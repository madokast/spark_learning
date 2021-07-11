package com.atguigu.ch04函数

object A02Recur {
  def main(args: Array[String]): Unit = {
    val b = new B()

    println(b.r(40))
  }
}

class B{
  def r(n:Int):Int= {
    if(n<=2) {
    return 1
    } else{
      var temp:Int = r(n-1)+r(n-2)
      temp = temp + 1
      return temp
    }
  }
}
