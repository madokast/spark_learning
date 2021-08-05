package com.atguigu.spark.core.dataFrame

import org.apache.spark.SparkConf
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DoubleType, LongType, StructField, StructType}

/**
 * @Description UserDefinedFunAgg
 * @Date 2021/8/3 17:43
 * @Created by ZhaoRX
 */
object UserDefinedFunAgg {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[1]").setAppName("sql")

    val sparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    val dataFrame = sparkSession.read.json("data/users.json")

    dataFrame.createOrReplaceTempView("user")

    sparkSession.udf.register("MyAvg",new MyAvg())

    sparkSession.sql("select MyAvg(age) from user").show()

    sparkSession.close()
  }

  class MyAvg extends UserDefinedAggregateFunction {
    // 输入数据结构
    override def inputSchema: StructType = StructType(Array(StructField("age", LongType)))

    // 缓冲区数据结构
    override def bufferSchema: StructType = StructType(Array(
      StructField("total", LongType),
      StructField("count", LongType)
    ))

    // 输出数据类型
    override def dataType: DataType = DoubleType

    // 函数稳定性。传入相同的参数，结果是否相同
    override def deterministic: Boolean = true

    // 缓冲区初始化
    override def initialize(buffer: MutableAggregationBuffer): Unit = {
      buffer(0) = 0L // total
      buffer(1) = 0L // count
    }

    // 根据表每一行的值，更新缓冲区
    override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
      buffer.update(0, buffer.getLong(0) + input.getLong(0)) // total + age
      buffer.update(1, buffer.getLong(1) + 1) // count++
    }

    // 缓冲区数据合并
    override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
      buffer1.update(0, buffer1.getLong(0) + buffer2.getLong(0)) // total + total
      buffer1.update(1, buffer1.getLong(1) + buffer2.getLong(1)) // count + count
    }

    // 计算平均值
    override def evaluate(buffer: Row): Any = {
      buffer.getLong(0).toDouble / buffer.getLong(1).toDouble
    }
  }
}
