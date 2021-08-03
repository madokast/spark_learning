package com.atguigu.spark.core.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description map partition
 * @Date 2021/8/2 10:56
 * @Created by ZhaoRX
 */
object MapPartitions {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    val rdd = logic3(sc)
    rdd.foreach(println)
    sc.stop()
  }

  def logic(sc: SparkContext): RDD[_] = {
    sc.makeRDD(List(1, 2, 3, 4))
      .mapPartitions(iterator => {
        iterator.map(_ * 2)
      })
  }

  def logic2(sc: SparkContext): RDD[_] = {
    sc.makeRDD(List(1, 2, 3, 4))
      .mapPartitions(iterator => {
        iterator.filter(_ % 2 == 0)
      })
  }

  def logic3(sc: SparkContext): RDD[_] = {
    sc.makeRDD(List(1, 2, 3, 4), numSlices = 2)
      .mapPartitions(iterator => {
        List(iterator.max).iterator
      })
  }
}
