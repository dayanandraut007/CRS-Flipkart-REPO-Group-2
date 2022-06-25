package com.flipkart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {
    public static Connection getConnection() {

        Connection connection = null;
        if (connection != null) return connection;

        else {
            try {
                // hardcoded properties
                String driver = "com.mysql.cj.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/CRSDatabase";
                String user = "root";
                String password = "password";

                // add properties code here

                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);


            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (SQLException e) {
                e.printStackTrace();

            }

            return connection;

        }


    }

}
