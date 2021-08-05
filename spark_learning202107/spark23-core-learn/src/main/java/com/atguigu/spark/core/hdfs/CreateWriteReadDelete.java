package com.atguigu.spark.core.hdfs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CreateWriteReadDelete {
    public static final Log LOG = LogFactory.getLog(CreateWriteReadDelete.class);

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop31:8020"), conf, "root");
        String wordCountInput = "/wordCountInput.txt";
        delete(fs, wordCountInput);
        write(fs, wordCountInput, TEXT);
        readLog(fs, wordCountInput);
        delete(fs, wordCountInput);
        fs.close();
    }

    private static void write(FileSystem fs, String path, String[] text) throws IOException {
        FSDataOutputStream outputStream = fs.create(new Path(path));
        for (String line : text) {
            outputStream.write(line.getBytes());
        }
        outputStream.flush();
        outputStream.close();
        LOG.info("创建" + path);
    }

    private static void readLog(FileSystem fs, String path) throws IOException {
        FSDataInputStream inputStream = fs.open(new Path(path));
        byte[] data = new byte[1024];
        int end = inputStream.read(data);
        String text = new String(data,0,end);
        LOG.info(path + "内容为：\n" + text);
    }

    private static void delete(FileSystem fs, String path) throws IOException {
        if (fs.delete(new Path(path), true)) {
            LOG.info(path + "删除成功");
        }
    }

    private static String[] TEXT = new String[]{
            "aaa bbb\n",
            "ccc aaa\n",
            "bbb bbb"
    };
}
