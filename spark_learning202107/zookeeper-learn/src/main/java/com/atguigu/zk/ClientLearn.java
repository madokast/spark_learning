package com.atguigu.zk;

import org.apache.zookeeper.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ClientLearn {
    private static final Logger LOG = LoggerFactory.getLogger(ClientLearn.class);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        // 地址集群
        // 等待时间 2000 ms
        // 监听器
        ZooKeeper zooKeeper = new ZooKeeper(
                "hadoop31:2181,hadoop32:2181,hadoop33:2181",
                2000,
                new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        LOG.info("监听到事件：{}", watchedEvent);
                    }
                });



        zooKeeper.close();
    }

    void createNode(ZooKeeper client,String path,String data) throws InterruptedException, KeeperException {
        // 节点名
        // 节点数据
        // 权限 OPEN_ACL_UNSAFE 任何人访问
        // 节点类型：持久、顺序
        client.create(
                path,
                data.getBytes(StandardCharsets.UTF_8),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT
        );
    }


}
