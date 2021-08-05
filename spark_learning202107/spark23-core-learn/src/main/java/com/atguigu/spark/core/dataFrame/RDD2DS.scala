package com.atguigu.spark.core.dataFrame

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @Description DataSetTest
 * @Date 2021/8/3 17:43
 * @Created by ZhaoRX
 */
object RDD2DS {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[1]").setAppName("sql")

    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    val rdd = sparkSession.sparkContext.makeRDD(List(
      ("aa", 1), ("bb", 2)
    ))

    import sparkSession.implicits._
    val dataFrame = rdd.toDF("name", "id")

    val dataSet = dataFrame.as[User]

    dataSet.show()


    sparkSession.close()
  }

  case class User(name: String, id: Int)
}
