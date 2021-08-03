package com.atguigu.spark.core.other

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description adder
 * @Date 2021/8/3 11:33
 * @Created by ZhaoRX
 */
object SharedAdder {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[1]").setAppName("adder")
    val sc = new SparkContext(sparkConf)

    val sum = sc.longAccumulator("sum")

    sc.makeRDD(List(1, 2, 3, 4))
      .foreach(sum.add(_))

    println(sum.value)
    sc.stop()
  }
}
