package com.atguigu.bigdata.spark.core;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class A01WordCountJ {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("w");
        JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);

        sparkContext.textFile("data/word_count.txt")
                .flatMap(line-> Arrays.asList(line.split(" ")).iterator())
                .groupBy(w->w)
                .map(t->{
                    Iterator<String> iter = t._2().iterator();
//                    System.out.println(iter.getClass());
                    int c = 0;
                    while (iter.hasNext()){
                        c++;
                        iter.next();
                    }
                    return new Tuple2<String,Integer>(t._1,c);
                })
                .collect()
                .forEach(System.out::println);


        sparkContext.stop();
    }
}
