package com.demo.app;

import java.util.Scanner;

import com.demo.service.StudentService;


public class App {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();

        Scanner sc = new Scanner(System.in);
        char again;
        int choice;
    
        System.out.println("Application started successfully");
        System.out.println("Do you want to continue? (y/n): ");
        again = sc.nextLine().charAt(0);

        System.out.println("=========== Student Management System ===========");

        while(again != 'n') {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    
                    studentService.redgisterStudent();
                    break;
                case 2:
                    
                    studentService.listAllStudents();
                    break;
                case 3:
                
                    studentService.removeStudent();
                    break;
                case 4:
                    System.out.println("Exiting Application...");
                    System.exit(0);
                default:
                    break;
            }
        System.out.println("Do you want to continue? (y/n): ");
        again = sc.nextLine().charAt(0);
    }

        System.out.println("Application terminated. Thanks to use the system!");
        sc.close();

    }

    public static void showMenu() {
        System.out.println("1. Register Student");
        System.out.println("2. List All Students");
        System.out.println("3. Remove Student");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}
