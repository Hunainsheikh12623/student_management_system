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

        do {
            System.out.println("\n=========== Student Management System ===========");
            showMenu();

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        studentService.registerStudent();
                        break;
                    case 2:
                        studentService.listAllStudents();
                        break;
                    case 3:
                        studentService.removeStudent();
                        break;
                    case 4:
                        studentService.getStudentById();
                        break;
                    case 5:
                        studentService.updateStudentById();
                        break;
                    case 6:
                        System.out.println("Exiting application...");
                        sc.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }

            System.out.print("\nDo you want to continue? (y/n): ");
            again = sc.nextLine().toLowerCase().charAt(0);

        } while (again == 'y');

        System.out.println("Application terminated. Thanks for using the system!");
        sc.close();
    }

    private static void showMenu() {
        System.out.println("1. Register Student");
        System.out.println("2. List All Students");
        System.out.println("3. Remove Student");
        System.out.println("4. Get Student By Id");
        System.out.println("5. Update Student By Id");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
}
