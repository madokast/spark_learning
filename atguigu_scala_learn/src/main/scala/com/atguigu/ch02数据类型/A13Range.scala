package com.atguigu.ch02数据类型

/**
 * 控制步长
 */
object A13Range {
  def main(args: Array[String]): Unit = {
    for (i <- Range(1, 3)) print(i)
    println()

    for (i <- Range(1, 10, 2)) print(i)
    println()

    for (i <- Range.inclusive(1,10)) print(i)
    println()

    for (i <- Range.inclusive(1,10,2)) print(i)
    println()
  }
}
