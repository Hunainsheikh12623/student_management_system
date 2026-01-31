package com.demo.dao;

import com.demo.model.Student;
import com.demo.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {

    String sql = "INSERT INTO students(name, age, email) VALUES (?, ?, ?)";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement ps = conn.prepareStatement(
                 sql,
                 Statement.RETURN_GENERATED_KEYS
         )) {

        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        ps.setString(3, student.getEmail());

        ps.executeUpdate();

        // 🔑 FETCH GENERATED ID
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            student.setId(rs.getInt(1));
        }

        System.out.println("✅ Student inserted successfully");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                        
                );
                student.setId(rs.getInt("id"));
                students.add(student);          
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

            System.out.println("✅ Student deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
