package com.atguigu.spark.core.other;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.launcher.SparkAppHandle;
import org.apache.spark.launcher.SparkLauncher;

import java.io.IOException;
import java.util.Arrays;

/**
 * 失败！
 */
public class SparkLauncherLearn {
    public static void main(String[] args) throws IOException, InterruptedException {
        SparkLauncherLearn instance = new SparkLauncherLearn();
        if(args.length==0){
            System.out.println("instance.launchJob();");
            instance.launchJob();
        }else {
            System.out.println("instance.sparkRun();");
            instance.sparkRun();
        }
    }

    private void sparkRun() {
        SparkConf conf = new SparkConf();
        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
        Integer reduced = javaSparkContext.parallelize(Arrays.asList(1, 2, 3, 4, 5, 5, 5, 5))
                .reduce(Integer::sum);
        System.out.println("reduced = " + reduced);
        javaSparkContext.stop();
    }

    private void launchJob() throws IOException, InterruptedException {
        SparkLauncher sparkLauncher = new SparkLauncher();
        sparkLauncher.setAppName("SparkLauncherLearn")
                .setMaster("local[2]")
                .setMainClass(this.getClass().getCanonicalName())
                .setAppResource("C:\\Users\\ZhaoRX\\Documents\\file\\spark_learning\\spark_learning202107\\spark23-core-learn\\target\\spark23-core-learn-1.0-SNAPSHOT.jar")
                .addAppArgs("go");


        SparkAppHandle handle = sparkLauncher.startApplication();
        while (true){
            System.out.println("########" + handle.getState());
            Thread.sleep(1000);
        }
    }
}
