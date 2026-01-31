package com.demo.app;

import com.demo.dao.StudentDAO;
import org.junit.jupiter.api.Test;

public class TestApp {

    @Test
    void testDatabaseConnection() {
        StudentDAO dao = new StudentDAO();
        dao.getAllStudents();
        System.out.println("✅ Database connected successfully");
    }
}
