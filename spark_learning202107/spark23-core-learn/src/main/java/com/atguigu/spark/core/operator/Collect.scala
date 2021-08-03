package com.atguigu.spark.core.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description collect
 * @Date 2021/8/2 10:56
 * @Created by ZhaoRX
 */
object Collect {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    println(sc.makeRDD(List(1, 2, 3, 4)).collect.mkString("Array(", ", ", ")"))
    sc.stop()
  }
}
