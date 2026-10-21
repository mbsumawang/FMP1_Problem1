package com.mycompany.studentgrade;

import java.util.Scanner;

public class Studentgrade {
    static Student[] students = new Student[5];
    static int studentCount = 0;
    static Scanner input = new Scanner(System.in);

    static class Student {
        String name;
        double grade;

        Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }

        void display() {
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    static void addStudent() {
    if (studentCount >= students.length) {
        System.out.println("Grade book is already full.");
        return;
    }

    System.out.print("Enter student name: ");
    String name = input.nextLine().trim();

    if (name.isEmpty()) {
        System.out.println("Student name cannot be empty.");
        return;
    }

    System.out.print("Enter grade (0-100): ");
    String gradeInput = input.nextLine();

    double grade;

    try {
        grade = Double.parseDouble(gradeInput);
    } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number for the grade.");
        return;
    }

    if (grade < 0 || grade > 100) {
        System.out.println("Grade must be between 0 and 100.");
        return;
    }

    students[studentCount] = new Student(name, grade);
    studentCount++;

    System.out.println("Student added successfully.");
}

    static void showRecords() {
        if (studentCount == 0) {
            System.out.println("No student record available.");
            return;
        }

        System.out.println("\nStudent Records:");

        for (int i = 0; i < studentCount; i++) {
            System.out.println("\nStudent " + (i + 1));
            students[i].display();
        }
    }

    static void lookupStudent() {
        if (studentCount == 0) {
            System.out.println("No student record available.");
            return;
        }

        System.out.print("Enter student name to search: ");
        String searchName = input.nextLine().trim();

        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (students[i].name.equalsIgnoreCase(searchName)) {
                System.out.println("\nStudent found:");
                students[i].display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\nMenu");
            System.out.println("1. Add");
            System.out.println("2. List");
            System.out.println("3. Lookup");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String choiceInput = input.nextLine();

            try {
                choice = Integer.parseInt(choiceInput);

                switch (choice) {
                    case 1:
                        addStudent();
                        break;

                    case 2:
                        showRecords();
                        break;

                    case 3:
                        lookupStudent();
                        break;

                    case 0:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
                choice = -1;
            }

        } while (choice != 0);
    }
}