package com.demo.dao;

import com.demo.model.Student;
import com.demo.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {

    String sql = "INSERT INTO Students(id, name, age, email) VALUES (?, ?, ?, ?)";

    try (Connection conn = DBUtil.getConnection();
         PreparedStatement ps = conn.prepareStatement(
                 sql,
                 Statement.RETURN_GENERATED_KEYS
         )) {

        ps.setString(1, student.getId());
        ps.setString(2, student.getName());
        ps.setInt(3, student.getAge());
        ps.setString(4, student.getEmail());

        ps.executeUpdate();

       

        System.out.println("✅ Student inserted successfully");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Students";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                        
                );
                students.add(student);          
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public void deleteStudent(String id) {
        String sql = "DELETE FROM Students WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.executeUpdate();

            System.out.println("✅ Student deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentById(String id) {
        String sql = "SELECT * FROM Students WHERE id = ?";
        Student student = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                student = new Student(
                        rs.getString("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    
    public void updateStudentById(String id, Student updatedStudent) {
        String sql = "UPDATE Students SET name = ?, age = ?, email = ? WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, updatedStudent.getName());
            ps.setInt(2, updatedStudent.getAge());
            ps.setString(3, updatedStudent.getEmail());
            ps.setString(4, id);

            ps.executeUpdate();

            System.out.println("✅ Student updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
            

