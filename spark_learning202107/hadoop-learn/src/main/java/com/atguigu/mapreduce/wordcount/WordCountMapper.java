package com.atguigu.mapreduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * LongWritable, Text, Text, IntWritable
 * 分别是输入的 K-V，输出的 K-V
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text keyOut = new Text();
    private IntWritable valueOutOne = new IntWritable(1);

    @Override
    protected void map(LongWritable keyIn, Text valueIn, Context context) throws IOException, InterruptedException {
        // read a line
        String line = valueIn.toString();
        // split
        String[] words = line.split(" ");
        // output
        for (String word : words) {
            keyOut.set(word);
            context.write(keyOut, valueOutOne);
        }
    }
}
