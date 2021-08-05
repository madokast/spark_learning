package com.atguigu.spark.core.hive

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object InnerTables {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[1]").setAppName("mysql")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    spark.sql("show tables").show

    spark.close()
  }
}
