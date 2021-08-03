package com.atguigu.spark.core.other

/**
 * @Description 双括号
 * @Date 2021/8/2 16:32
 * @Created by ZhaoRX
 */
object DoubleBrace {
  def main(args: Array[String]): Unit = {
    println(add(3)(4))
  }

  def add(a: Int)(b: Int) = a + b
}
