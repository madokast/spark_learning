package com.atguigu.spark.core.operator;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;

public class AggregateByKeyJava {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("AggregateByKeyJava");
        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
        javaSparkContext.parallelize(Arrays.asList(1, 2, 3, 4, 5, 5, 5, 5))
                .mapToPair(num -> new Tuple2<>(num, num))
                .reduceByKey(Integer::sum)
                .collect()
                .forEach(System.out::println);

        javaSparkContext.stop();
    }
}
