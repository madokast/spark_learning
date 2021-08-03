package com.atguigu.spark.core.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
 * @Description Intersection
 * @Date 2021/8/2 10:56
 * @Created by ZhaoRX
 */
object Intersection {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    val rdd = logic(sc)
    rdd.foreach(println)
    sc.stop()
  }

  def logic(sc: SparkContext): RDD[_] = {
    val rdd1 = sc.makeRDD(List(1, 2, 3, 4))
    val rdd2 = sc.makeRDD(List(5, 2, 7, 8))
    rdd1.intersection(rdd2)
  }
}
