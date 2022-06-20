package com.flipkart.application;

import java.util.Scanner;

public class CRSApplication {
    public static void main(String[] args) {

        System.out.println("Welcome to CRS Application");
        System.out.println("------------------------------");
        System.out.println("1. Login");
        System.out.println("2. Registration  of Student");
        System.out.println("3. Update Password");
        System.out.println("4. Exit");
        while (true) {
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Write logic for login");
                    break;
                case 2:
                    System.out.println("Write logic for Registration");
                    break;

                case 3:
                    System.out.println("Write logic for update password");
                    break;

                case 4:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Select the menu properly");

            }
        }
    }
}
