package com.atguigu.spark.core.dataFrame

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @Description date frame
 * @Date 2021/8/3 17:43
 * @Created by ZhaoRX
 */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[1]").setAppName("sql")

    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    println(sparkSession)

    sparkSession.close()
  }
}
