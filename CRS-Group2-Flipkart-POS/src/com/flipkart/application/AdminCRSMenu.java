package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;

import java.util.List;
import java.util.Scanner;

public class AdminCRSMenu {

    AdminInterface adminInterface = new AdminImpl();

    public void addCourse(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Course Code:");
        String courseCode = sc.next();
        System.out.print("Course Name:");
        String name = sc.nextLine();
        System.out.print("Course Instructor:");
        String instructor = sc.nextLine();
        System.out.print("Course prerequisites:");
        String prerequisites = sc.nextLine();
        System.out.print("Number of seats:");
        int seats = sc.nextInt();
        Course newCourse= new Course(courseCode,name,true,instructor,prerequisites,seats);
        adminInterface.addCourse(newCourse);

    }

    public void deleteCourse(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Course Code to be Deleted:");
        String courseCodeDelete = sc.next();
        adminInterface.deleteCourse(courseCodeDelete);

    }

    public void createMenu() {
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
                    List<Course> course = adminInterface.viewCourses();
                    for(Course cs: course){
                        System.out.println(cs.getCourseCode());

                    }
                    break;
                case 2:
                    addCourse();
                    break;

                case 3:
                    deleteCourse();
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
