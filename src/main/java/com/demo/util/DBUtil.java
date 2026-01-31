package com.demo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Strong@123";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
