package com.atguigu.hive2;

import java.sql.*;

/**
 * @Description 测试连接 hive2
 * @Date 2021/7/29 17:12
 * @Created by ZhaoRX
 */
public class ConnectTest {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:hive2://192.168.21.105:10000/test","root","root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from test");

        resultSet.next();
        String s = resultSet.getString(1);
        System.out.println("s = " + s);

        resultSet.close();
        statement.close();
        connection.close();
    }
}
