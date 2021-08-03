package com.atguigu.spark.core.operator

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
 * @Description 扁平映射
 * @Date 2021/8/2 10:56
 * @Created by ZhaoRX
 */
object FlatMap {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    val rdd = logic2(sc)
    rdd.foreach(println)
    sc.stop()
  }

  def logic(sc: SparkContext): RDD[_] = {
    sc.makeRDD(List(1, 2, 3, 4))
      .flatMap(num => {
        val ret = new ListBuffer[Int]
        ret.size
        for (_ <- 0 to num) ret.append(num)
        ret
      })
  }

  def logic2(sc: SparkContext): RDD[_] = {
    sc.makeRDD(List(1, 2, 3, 4))
      .flatMap(num => {
        (0 until num).map(_ => num)
      })
  }
}
