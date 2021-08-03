package com.atguigu.spark.core.other

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description BroadcastValue
 * @Date 2021/8/3 11:33
 * @Created by ZhaoRX
 */
object BroadcastValue {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[1]").setAppName("adder")
    val sc = new SparkContext(sparkConf)

    val bigTable = sc.makeRDD(List(
      ("a",1),("b",1),("c",1)
    ))

    val smallTable = Map(("a",2),("b",3),("c",4))

    val smallTableBroadcast = sc.broadcast(smallTable)

    bigTable.map({
      case (key,value)=>(key,(value,smallTableBroadcast.value.getOrElse(key,-1)))
    }).collect().foreach(println)

    sc.stop()
  }
}
