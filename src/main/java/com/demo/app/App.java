package com.demo.app;

import com.demo.util.DBUtil;

public class App {
    public static void main(String[] args) {
        DBUtil.getConnection();
        System.out.println("Application started successfully");
    }
}
