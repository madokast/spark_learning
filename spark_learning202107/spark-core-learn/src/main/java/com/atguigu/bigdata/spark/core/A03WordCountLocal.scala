package com.atguigu.bigdata.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object A03WordCountLocal {
  def main(args: Array[String]): Unit = {
    // 建立和 spark 的连接
    val sparkConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    sc.makeRDD(new Array(){"hello world","hello spark","hello world"})

  }
}
