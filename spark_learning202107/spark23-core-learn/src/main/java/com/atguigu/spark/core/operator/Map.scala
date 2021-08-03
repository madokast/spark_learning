package com.atguigu.spark.core.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description map
 * @Date 2021/8/2 10:56
 * @Created by ZhaoRX
 */
object Map {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[1]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    val rdd = logic(sc)
    rdd.foreach(println)
    sc.stop()
  }

  def logic(sc: SparkContext): RDD[_] = {
    sc.makeRDD(List(1, 2, 3, 4))
      .map(_ * 2)
  }

  def logic2(sc: SparkContext): RDD[_] = {
    var i = 0
    val temp = sc.makeRDD(List(1, 2, 3, 4))
      .map(e => {
        i += 1
        print("--" + i)
        e * 2
      })

    println(i)

    temp
  }
}
