package com.atguigu.ch06面向对象

/**
 * 修饰符 class Name{
 * body
 * }
 *
 * 修饰符不写，默认 public
 *
 */
object A01类 {
  def main(args: Array[String]): Unit = {
    val d = new Dog
    println(d)
    println(d.name)
    println(d.age)
    println(d.n)
    //    println(d.n.getClass) // npe

    println({})
    println({
      1
    })
    println({
      1 -> 2
    })

    println({}.getClass)
    println({
      1
    }.getClass)
    println({
      1 -> 2
    }.getClass)

  }
}

class Dog {
  // 属性
  // 必须显式初始化
  var name = "jack"
  var age: Int = _
  var n = null // 不指定类型则 n 类型为 Null
}

