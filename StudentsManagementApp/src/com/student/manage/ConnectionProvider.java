package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
   static Connection con;

    public static Connection createC() {
        try {
            // register or load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // create connection
            String url = "jdbc:mysql://localhost:3306/Students";
            String user = "root";
            String password = "root@123";
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
