package com.flipkart.application;

import java.util.Scanner;

public class ProfessorCRSMenu {
    public static void main(String[] args) {
        System.out.println("------------Professor CRS Menu---------------");
        System.out.println("------------------------------");
        System.out.println("1. View Assigned Courses");
        System.out.println("2. View Enrolled Students");
        System.out.println("3. Add Grade");
        System.out.println("4. Register For Teaching a Course");
        System.out.println("5. Logout");
        while (true) {
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Write logic for view assigned courses");
                    break;
                case 2:
                    System.out.println("Write logic for view enrolled students");
                    break;

                case 3:
                    System.out.println("Write logic for adding grade");
                    break;

                case 4:
                    System.out.println("Write logic for teach course registration");
                    break;

                case 5:
                    System.out.println("logout");
                    break;

                default:
                    System.out.println("Select the menu properly");

            }
        }
    }
}
