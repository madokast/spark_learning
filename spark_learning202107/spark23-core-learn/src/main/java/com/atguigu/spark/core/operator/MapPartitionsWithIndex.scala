package com.atguigu.spark.core.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description map partition with id
 * @Date 2021/8/2 10:56
 * @Created by ZhaoRX
 */
object MapPartitionsWithIndex {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    val rdd = logic(sc)
    rdd.foreach(println)
    sc.stop()
  }

  def logic(sc: SparkContext): RDD[_] = {
    sc.makeRDD(List(1, 2, 3, 4))
      .mapPartitionsWithIndex((index, iter) => {
        val sb = new StringBuilder
        sb.append("分区" + index + "的数据是：")
        while (iter.hasNext) sb.append(iter.next + " ")
        println(sb)
        iter
      })
  }
}
