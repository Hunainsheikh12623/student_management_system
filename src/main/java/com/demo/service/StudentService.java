package com.demo.service;

import java.util.Scanner;

import com.demo.dao.StudentDAO;
import com.demo.model.Student;

public class StudentService {

    Scanner sc = new Scanner(System.in);

    String id;
    String name;
    int age;
    String email;

    StudentDAO studentDAO = new StudentDAO();
    

    public void registerStudent() {

        System.out.println("--- Register New Student ---");
        System.out.println("Enter Id: ");
        id = sc.nextLine();
        System.out.println("Enter Name: ");
        name = sc.nextLine();
        System.out.println("Enter Age: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Email: ");
        email = sc.nextLine();

        Student student = new Student(id,  name, age, email);
        studentDAO.addStudent(student);

        System.out.println("Registered Student Details: " + student);
        System.out.println("Student registered successfully!");
        System.out.println("-----------------------------");
    }

    public void listAllStudents() {
        System.out.println("--- List of All Students ---");
        for (Student student : studentDAO.getAllStudents()) {
            System.out.println(student);
        }
        System.out.println("----------------------------");
    }

    public void removeStudent() {
        System.out.println("Enter Student Id to remove: ");
        id = sc.nextLine();
        studentDAO.deleteStudent(id);
        System.out.println("Student removed successfully!");
    }

    

}
