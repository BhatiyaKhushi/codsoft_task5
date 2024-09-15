package com.codsoft.studentmanagement;

import java.util.Scanner;

public class StudentManagementSystemApp {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManagementSystem msg = new StudentManagementSystem();
    private static boolean running = true;

    public static void main(String[] args) {
        while (running) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    handleExit();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addStudent() {
        try {
            System.out.print("Enter a student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter a student roll number: ");
            String rollNumber = scanner.nextLine();
            System.out.print("Enter grade: ");
            String grade = scanner.nextLine();
            System.out.print("Enter email (must be Gmail): ");
            String email = scanner.nextLine();
            System.out.print("Enter phone number (10 digits): ");
            String phoneNo = scanner.nextLine();
            System.out.print("Enter city: ");
            String city = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 

            Student student = new Student(name, rollNumber, grade, email, phoneNo, city, age);
            msg.addStudent(student);
            System.out.println("Student added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removeStudent() {
        System.out.print("Enter roll number of student to remove: ");
        String rollNumber = scanner.nextLine();
        msg.removeStudent(rollNumber);
        System.out.println("Student removed if existed.");
    }

    private static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        String rollNumber = scanner.nextLine();
        Student student = msg.searchStudent(rollNumber);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() {
        msg.displayAllStudents();
    }

    private static void handleExit() {
        System.out.println("Are you sure you want to exit? (y/n)");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("y") || confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Exiting... Have a great day!");
            running = false;
        } else {
            System.out.println("Application is not exiting... Returning to menu...");
        }
    }
}
