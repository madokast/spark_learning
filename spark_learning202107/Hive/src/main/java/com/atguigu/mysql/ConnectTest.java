package com.atguigu.mysql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description mysql 连接测试
 * @Date 2021/7/29 11:52
 * @Created by ZhaoRX
 */
public class ConnectTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://192.168.21.104:3306/mysql?useSSL=false", "root", "root");
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println(metaData.getDatabaseMajorVersion());
        connection.close();
    }
}
