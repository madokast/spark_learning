package com.atguigu.spark.core.dataFrame


import org.apache.spark.{Aggregator, SparkConf}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types._
import org.apache.spark.sql.{Encoder, Encoders, Row, SparkSession, functions}

/**
 * @Description UserDefinedFunAgg
 * @Date 2021/8/3 17:43
 * @Created by ZhaoRX
 */
object UserDefinedFunAggType {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[1]").setAppName("sql")

    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    val dataFrame = sparkSession.read.json("data/users.json")

    import sparkSession.implicits._
    val dataSet = dataFrame.as[User]

    dataSet.select(new MyAvgAgg().toColumn).show()

    sparkSession.close()
  }

  case class User(name: String, age: Long)

  case class Buf(var total: Long, var count: Long)

  // 泛型为输入、缓存、输出
  class MyAvgAgg extends org.apache.spark.sql.expressions.Aggregator[User, Buf, Double] {

    override def zero: Buf = Buf(0, 0)

    override def reduce(b: Buf, u: User): Buf = {
      b.total += u.age
      b.count += 1
      b
    }

    override def merge(b1: Buf, b2: Buf): Buf = {
      b1.total += b2.total
      b1.count += b2.count
      b1
    }

    override def finish(reduction: Buf): Double = {
      reduction.total.toDouble / reduction.count.toDouble
    }

    // 缓冲区编码解码
    override def bufferEncoder: Encoder[Buf] = Encoders.product

    override def outputEncoder: Encoder[Double] = Encoders.scalaDouble
  }
}
