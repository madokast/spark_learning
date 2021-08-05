package com.atguigu.spark.core.dataFrame

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @Description dsl
 * @Date 2021/8/3 17:43
 * @Created by ZhaoRX
 */
object DSL {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[1]").setAppName("sql")

    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    val dataFrame = sparkSession.read.json("data/users.json")

    dataFrame.select("age","name").show()

    import sparkSession.implicits._
    dataFrame.select('age + 1).show()

    sparkSession.close()
  }
}
