package com.atguigu.spark.core.test

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description Top3
 * @Date 2021/8/2 17:35
 * @Created by ZhaoRX
 */
object Top3 {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)

    sc.makeRDD(List((1, 1, 1)))
      .map(t => ((t._1, t._2), t._3))
      .reduceByKey(_ + _)
      .map(t => (t._1._1, (t._1._2, t._2)))
      .groupByKey()
      .mapValues(v => v.toList.sortBy(_._2).reverse.take(3))
      .foreach(println)

    sc.stop()
  }
}
