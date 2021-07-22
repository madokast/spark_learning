package com.atguigu.bigdata.spark.core

import org.apache.spark.{SparkConf, SparkContext}

object A02WordCountReduce {
  def main(args: Array[String]): Unit = {
    // 建立和 spark 的连接
    val sparkConf = new SparkConf().setMaster("local").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    // 操作
    // 1. 读取文件，按行读取
    sc.textFile("data/word_count.txt")
      // 2. 将一行拆分为单词
      .flatMap(_.split(" "))
      // 3. 每个单词 map 为 (w,1)
      .map((_, 1))
      // 4. reduce by key
      .reduceByKey(Integer.sum)
      // 5. show
      .foreach(println)

    //(spark,1)
    //(hello,3)
    //(world,2)

    // 关闭链接
    sc.stop()
  }
}
