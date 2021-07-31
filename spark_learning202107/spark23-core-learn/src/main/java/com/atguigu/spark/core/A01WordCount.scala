package com.atguigu.spark.core

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @Description word count
 * @Date 2021/7/30 10:32
 * @Created by ZhaoRX
 */
object A01WordCount {
  def main(args: Array[String]): Unit = {
    // 建立和 spark 的连接
    val sparkConf = new SparkConf().setMaster("local[*]").setAppName("WordCount")
    val sc = new SparkContext(sparkConf)
    // 操作
    // 1. 读取文件，按行读取
    sc.textFile("data/word_count.txt")
      // 2. 将一行拆分为单词
      .flatMap(_.split(" "))
      // 3. 相同单词合并。(a,a,a)  (b,b)，即 group by self
      .groupBy(word => word)
      // 4. 分组后的数据，转换map 。(a,a,a)=>(a,3)  (b,b)=>(b,2)
      //      .map(group => (group._1, group._2.size))
      .map({ case (word, words) => (word, words.size) })
      .collect()
      // 5. 显示结果
      .foreach(println)

    // 关闭链接
    sc.stop()
  }
}
