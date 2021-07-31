package com.atguigu.spark.core.rdd

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description 创建 rdd
 * @Date 2021/7/30 21:14
 * @Created by ZhaoRX
 */
object CreateRDD{
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    sc.makeRDD(List(1,2,3,4)).foreach(println)
    sc.parallelize(List(5,6,7,8)).foreach(println)

    sc.textFile("data/word_count.txt").foreach(println)

    //
//    sc.makeRDD(List("abb","cdd")).saveAsTextFile("CreateRDD.txt")

    // 关闭链接
    sc.stop()
  }
}
