package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBUtil {

    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null) {
                Properties props = new Properties();
                InputStream is = DBUtil.class
                        .getClassLoader()
                        .getResourceAsStream("db.properties");

                props.load(is);

                String url = props.getProperty("db.url");
                String user = props.getProperty("db.username");
                String pass = props.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, pass);
                System.out.println("✅ Database connected successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
