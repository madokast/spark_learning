package com.atguigu.spark.core.other

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description Average
 * @Date 2021/8/2 17:01
 * @Created by ZhaoRX
 */
object Average {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    val rdd = logic(sc)
    rdd.foreach(println)
    sc.stop()
  }

  def logic(sc: SparkContext): RDD[_] = {
sc.makeRDD(List(
  ("a", 1),
  ("a", 2),
  ("a", 3),
  ("b", 1),
  ("b", 2)
))
  .aggregateByKey((0, 0.0))(
    { case (info, value) => (info._1 + 1, info._2 + value) },
    { case (info1, info2) => (info1._1 + info2._1, info1._2 + info2._2) }
  ).map({ case (key, info) => (key, info._2 / info._1) })
  }
}
