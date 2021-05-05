package com.argos.database;

import java.sql.*;

public class Db {
    public static void main(String[] args) throws SQLException {
        String url="https://database.com";
        String username="user";
        String password="pass";
        Connection connection = DriverManager.getConnection(url,username,password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from pets where pet_id between 100 and 200");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        resultSetMetaData.getColumnCount();
        resultSet.next();
        resultSet.getString(1);


    }
}
