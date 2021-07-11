package com.atguigu.bigdata.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object A01WordCount {
  def main(args: Array[String]): Unit = {
    // 建立和 spark 的连接
    val sparkConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    // 操作

    // 关闭链接
    sc.stop()
  }
}
