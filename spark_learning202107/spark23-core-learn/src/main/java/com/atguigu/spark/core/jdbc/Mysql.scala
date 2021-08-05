package com.atguigu.spark.core.jdbc

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Mysql {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[1]").setAppName("mysql")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._

    spark.read.format("jdbc")
      .option("url", "jdbc:mysql://192.168.21.104:3306/mysql")
      .option("driver", "com.mysql.jdbc.Driver")
      .option("user", "root")
      .option("password", "root")
      .option("dbtable", "user")
      .load
      .select("Host","User")
      .show()

    spark.close()
  }
}
