package com.atguigu.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description word count
 * @Date 2021/7/30 10:32
 * @Created by ZhaoRX
 */
object A01WordCount2 {
  def main(args: Array[String]): Unit = {
    // 建立和 spark 的连接
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    // 操作
    // 1. 读取文件，按行读取
sc.textFile("data/word_count.txt")
  .flatMap(_.split(" "))
  .countByValue()
  .foreach(println)

    // 关闭链接
    sc.stop()
  }
}
