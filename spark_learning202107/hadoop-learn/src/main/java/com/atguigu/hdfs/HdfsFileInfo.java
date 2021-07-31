package com.atguigu.hdfs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsFileInfo {
    public static final Log LOG = LogFactory.getLog(HdfsFileInfo.class);

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop01:9000"),conf,"root");
        FileStatus fileStatus = fs.getFileStatus(new Path("/hello_hadoop.txt"));
        LOG.info(fileStatus);
        fs.close();
    }
}
