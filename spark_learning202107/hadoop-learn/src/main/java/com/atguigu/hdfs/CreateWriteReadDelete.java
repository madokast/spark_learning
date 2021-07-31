package com.atguigu.hdfs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class CreateWriteReadDelete {
    public static final Log LOG = LogFactory.getLog(CreateWriteReadDelete.class);

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop01:9000"), conf, "root");
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
        byte[] data = IOUtils.readFullyToByteArray(inputStream);
        String text = new String(data);
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
