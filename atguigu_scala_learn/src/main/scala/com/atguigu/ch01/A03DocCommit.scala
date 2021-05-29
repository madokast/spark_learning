package com.atguigu.ch01

/**
 * 等价于 HelloWorld 的静态对象，单例
 *
 */
object A03DocCommit {
  def main(args: Array[String]): Unit = {
    println(sum(1, 2))
  }

  /**
   * 文旦注释
   *
   * @param a 加数
   * @param b 加数
   * @return a+b 求和
   */
  def sum(a: Int, b: Int): Int = a + b
}

