package com.atguigu.zk;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class WatchLearn {
    private static final Logger LOG = LoggerFactory.getLogger(WatchLearn.class);

    private ZooKeeper client;

    private void init() throws IOException {
        client = new ZooKeeper(
                "hadoop31:2181,hadoop32:2181,hadoop33:2181",
                2000,
                watchedEvent -> watchChildren("/sanguo"));
    }

    private void stop() {
        LOG.info("关闭{}", client);
        try {
            client.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void watchChildren(String path) {
        List<String> children = null;
        try {
            children = client.getChildren(path, true);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info("{}的子节点有{}", path, children);
    }


    void createNode(String path, String data) throws InterruptedException, KeeperException {
        client.create(
                path,
                data.getBytes(StandardCharsets.UTF_8),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT
        );
    }

    void deleteNode(String path) throws InterruptedException, KeeperException {
        client.delete(path, -1);
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        new WatchLearn().start();
    }

    private void start() throws IOException, InterruptedException, KeeperException {
        init();
        createNode("/sanguo/a", "123");
        createNode("/sanguo/b", "123");
        createNode("/sanguo/c", "123");
        createNode("/sanguo/d", "123");

        deleteNode("/sanguo/a");
        deleteNode("/sanguo/b");
        deleteNode("/sanguo/c");
        deleteNode("/sanguo/d");

        Thread.sleep(1000);

        Runtime.getRuntime().addShutdownHook(new Thread(this::stop,"shutdown"));
    }
}
