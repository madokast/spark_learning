package com.atguigu.mapreduce.wordcount;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.*;
import java.util.Objects;

public class WordCountLocal {
    public static final Log LOG = LogFactory.getLog(WordCountLocal.class);

    private static final String[] TEXT = new String[]{
            "aaa bbb\n",
            "ccc aaa\n",
            "bbb bbb"
    };

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        String inputDir = "./input";
        String inputFile = "i.txt";
        String outputDir = "./output";
        createInputFile(inputDir, inputFile);
        readFile(inputDir, inputFile);
        WordCountDriver.main(new String[]{new File(inputDir).getAbsolutePath(), new File(outputDir).getAbsolutePath()});
        LOG.info("---- MAP-REDUCE FINISHED -----");
        deletePath(inputDir);
        deletePath(outputDir);
    }

    private static void deletePath(String inputDir) throws IOException {
        File file = new File(inputDir);
        for (File child : Objects.requireNonNull(file.listFiles())) {
            if (child.isFile()) {
                readFile(inputDir, child.getName());
                if (child.delete()) {
                    LOG.info("删除文件："+ child.getAbsolutePath());
                }else {
                    throw new RuntimeException("文件删除失败" + child.getAbsolutePath());
                }
            } else {
                deletePath(child.getAbsolutePath());
            }
        }
        if (file.delete()) {
            LOG.info("删除路径："+ file.getAbsolutePath());
        }
    }

    private static void readFile(String inputDir, String inputFile) throws IOException {
        File file = new File(inputDir, inputFile);
        FileInputStream is = new FileInputStream(file);
        byte[] data = new byte[1000];
        int length = is.read(data);
        if (length>0) {
            String s = new String(data, 0, length);
            LOG.info(inputDir + inputFile + ":\n" + s);
        }
        is.close();
    }

    private static void createInputFile(String inputDir, String inputFile) throws IOException {
        File dir = new File(inputDir);
        if (dir.mkdir()) {
            LOG.info("路径创建成功" + inputDir);
            File file = new File(inputDir, inputFile);
            OutputStream os = new FileOutputStream(file);
            for (String line : TEXT) {
                os.write(line.getBytes());
            }
            os.flush();
            os.close();
        }
    }
}
