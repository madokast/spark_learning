package com.atguigu.spark.core.remote

import org.apache.spark.{SparkConf, SparkContext}

/**
 * com.atguigu.spark.core.remote.A01WordCountCluster
 * @Description word count
 * @Date 2021/7/30 10:32
 * @Created by ZhaoRX
 */
object A02SumCluster {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setAppName("SumCluster")
    val sc = new SparkContext(sparkConf)

    sc.stop()
  }
}
