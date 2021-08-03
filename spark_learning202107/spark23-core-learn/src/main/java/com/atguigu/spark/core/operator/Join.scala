package com.atguigu.spark.core.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description Join
 * @Date 2021/8/2 10:56
 * @Created by ZhaoRX
 */
object Join {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    val rdd = logic(sc)
    rdd.foreach(println)
    sc.stop()
  }

  def logic(sc: SparkContext): RDD[_] = {
    val rdd1 = sc.makeRDD(List(
      ("a", 1),
      ("b", 2),
      ("c", 3)
    ))

    val rdd2 = sc.makeRDD(List(
      ("a", 4),
      ("b", 5),
      ("c", 6),

      ("a", 100)
    ))

    rdd1.join(rdd2)
  }
}
