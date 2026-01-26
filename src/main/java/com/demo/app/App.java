package main.java.com.demo.app;

import main.java.com.demo.model.*;

public class App {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 20, "S12345", "johndoe@gmail.com");
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
        System.out.println("Student ID: " + student.getId());
        System.out.println("Student Email: " + student.getEmail());
    }

    public void sampleMethod() {
        // Sample method for demonstration
        System.out.println("Sample Method in App Class");
    }
}
