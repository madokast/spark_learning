package com.atguigu.mapreduce.wordcount;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class WordCountDriver {
    public static final Log LOG = LogFactory.getLog(WordCountDriver.class);

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        LOG.info("---------- MAP REDUCE STARTS -----------");
        LOG.info(args[0]);
        LOG.info(args[1]);

        // get job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        // jar location
        job.setJarByClass(WordCountDriver.class);

        // link mapper and reducer
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        // type of key and value in mapper
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        // type of key and value in reducer
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // path for input and output
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        // submit job
        job.submit();
        job.waitForCompletion(true);
    }
}
