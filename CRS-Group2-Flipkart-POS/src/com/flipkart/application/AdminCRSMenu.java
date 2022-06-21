package com.flipkart.application;

import java.util.Scanner;

public class AdminCRSMenu {
    public static void main(String[] args) {
        System.out.println("------------Admin CRS Menu---------------");
        System.out.println("------------------------------");
        System.out.println("1. View All Courses");
        System.out.println("2. Add new Course to Course Catalog");
        System.out.println("3. Delete a Course from Course Catalog");
        System.out.println("4. Add Professor to CRS");
        System.out.println("5. Approve Registration of Students");
        System.out.println("6. Assign Courses to Professor");
        System.out.println("7. Generate Grade Card for Students");
        System.out.println("8. Logout");
        while (true) {
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Write logic for view all courses");
                    break;
                case 2:
                    System.out.println("Write logic for add new course");
                    break;

                case 3:
                    System.out.println("Write logic for delete course");
                    break;

                case 4:
                    System.out.println("Write logic for add professor");
                    break;

                case 5:
                    System.out.println("Write logic for approve registration");
                    break;

                case 6:
                    System.out.println("Write logic for assign courses to professor");
                    break;

                case 7:
                    System.out.println("Write logic for generate grade card");
                    break;

                case 8:
                    System.out.println("Write logic for logout");
                    break;

                default:
                    System.out.println("Select the menu properly");

            }
        }
    }
}
