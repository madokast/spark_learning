package com.atguigu.spark.core.jdbc

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Hive {
  def main(args: Array[String]): Unit = {
    System.setProperty("HADOOP_USER_NAME","root")
    val conf = new SparkConf().setMaster("local[1]").setAppName("mysql")
    val spark = SparkSession.builder().config(conf)
      .config("spark.sql.warehouse.dir","hdfs://hadoop31:8020/user/hive/warehouse")
      .enableHiveSupport()
      .getOrCreate()
    import spark.implicits._

//    spark.sql("create table user(id int)").show()

//    spark.sql("LOAD DATA LOCAL INPATH 'data/id.txt' INTO TABLE user").show()

    1.to(10).foreach(i=>spark.sql(s"insert into user values($i)").show)

    spark.sql("select * from user").show()

    spark.close()
  }
}
