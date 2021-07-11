package com.atguigu.bigdata.spark.core;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;

public class A01WordCountJ {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("w");
        SparkContext sparkContext = new SparkContext(sparkConf);

        sparkContext.stop();
    }
}
