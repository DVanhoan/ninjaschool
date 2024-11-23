package com.hoiuc.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLManager {
    public static Connection conn;
    public static Statement stat;

    public static synchronized void create(String host, int port, String database, String user, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e2) {
            System.out.println("Driver mysql not found!");
            System.exit(0);
        }
        String url = "jdbc:mysql://bki0h9ql4tdfzrkzzxsl-mysql.services.clever-cloud.com:3306/bki0h9ql4tdfzrkzzxsl?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
        System.out.println("MySQL connect: " + url);
        try {
            SQLManager.conn = DriverManager.getConnection(url, "ujztcrjpe21qxbec", "ccmCyGguqmgZuAMSPPHk");
            SQLManager.stat = SQLManager.conn.createStatement();
            SQLManager.stat = SQLManager.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            System.out.println("Connect Success!");
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static synchronized boolean close() {
        System.out.println("Close connection to database");
        try {
            if (SQLManager.stat != null) {
                SQLManager.stat.close();
            }
            if (SQLManager.conn != null) {
                SQLManager.conn.close();
            }
            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
