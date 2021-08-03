package com.atguigu.spark.core.other

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description 持久化
 * @Date 2021/8/3 10:51
 * @Created by ZhaoRX
 */
object Persist {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[1]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    val rdd = sc.makeRDD(0.until(100000)).map(_ * 2)

    print("没有持久化")
    var time = System.currentTimeMillis()
    0.until(10).foreach(_ => {
      // 使用两次行动算子
      println(rdd.reduce(_ + _))
      println(rdd.count())
    })
    println("用时" + (System.currentTimeMillis() - time))

    rdd.cache()
    print("持久化")
    time = System.currentTimeMillis()
    0.until(10).foreach(_ => {
      // 使用两次行动算子
      println(rdd.reduce(_ + _))
      println(rdd.count())
    })
    println("用时" + (System.currentTimeMillis() - time))

    sc.stop()
  }
}
