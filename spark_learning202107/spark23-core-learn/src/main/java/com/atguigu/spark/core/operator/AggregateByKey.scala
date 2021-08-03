package com.atguigu.spark.core.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
 * @Description 扁平映射
 * @Date 2021/8/2 10:56
 * @Created by ZhaoRX
 */
object AggregateByKey {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    val rdd = logic(sc)
    rdd.foreach(println)
    sc.stop()
  }

  def logic(sc: SparkContext): RDD[_] = {
    sc.makeRDD(List(("a", 1), ("a", 1), ("a", 2), ("a", 2)), 2)
      .aggregateByKey(0)(_ + _, _ * _) // 8
  }

  def logic2(sc: SparkContext): RDD[_] = {
    sc.makeRDD(List(("a", 1), ("a", 1), ("a", 2), ("a", 2)), 2)
      .foldByKey(0)(_ + _) // 8
  }
}
