package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.service.StudentImpl;

import java.util.List;
import java.util.Scanner;

public class StudentCRSMenu {

    public void createMenu(){

        StudentImpl student=new StudentImpl();
        System.out.println("------------Student CRS Menu---------------");
        System.out.println("------------------------------");
        System.out.println("1. Course Registration");
        System.out.println("2. Add Course");
        System.out.println("3. Drop Course");
        System.out.println("4. View Registered Courses");
        System.out.println("5. Make Payment");
        System.out.println("6. View Grade Card");
        System.out.println("7. View All Courses");
        System.out.println("8. Logout");
        while (true) {
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Write logic for course registration");
                    break;
                case 2:
                    System.out.println("Write logic for add course");
                    break;

                case 3:
                    System.out.println("Write logic for drop course");
                    break;

                case 4:
                    System.out.println("Write logic for view registered courses");
                    break;

                case 5:
                    System.out.println("Write logic for making payment");
                    break;

                case 6:
                    System.out.println("Write logic for view grade card");
                    break;

                case 7:

                    List<Course> course = student.viewAllCourses();
                    for(Course cs: course){
                        System.out.println(cs.getCourseCode());

                    }
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
