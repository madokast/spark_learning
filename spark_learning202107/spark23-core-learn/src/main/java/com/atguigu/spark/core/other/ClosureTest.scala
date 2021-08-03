package com.atguigu.spark.core.other

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description 闭包和序列化
 * @Date 2021/8/2 20:18
 * @Created by ZhaoRX
 */
object ClosureTest {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[1]").setAppName("x")
    val sc = new SparkContext(sparkConf)
    val user = new User()
    sc.makeRDD(List(1, 2)).foreach(_ => {
      println(user.age)
    })
    sc.stop()
  }
}

class User {
  val age = 10
}

/*


 */
