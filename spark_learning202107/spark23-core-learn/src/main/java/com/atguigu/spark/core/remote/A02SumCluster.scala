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
    // 建立和 spark 的连接
    val sparkConf = new SparkConf().setAppName("SumCluster")
    val sc = new SparkContext(sparkConf)
    sc.setLogLevel("INFO")
    // 操作
    // 1. 读取文件，按行读取
    sc.makeRDD(List(1,2,3,4))
      .reduce(_+_)

    // 关闭链接
    sc.stop()
  }
}
