package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.service.StudentImpl;

import java.util.List;
import java.util.Scanner;

public class StudentCRSMenu {

    CRSApplication crsApplication = new CRSApplication();

    public void createMenu(String userId){

        StudentImpl student=new StudentImpl();
        System.out.println("============================================");
        System.out.println("--------------STUDENT CRS MENU------------");
        System.out.println("============================================");
        System.out.println("1. Course Registration");
        System.out.println("2. Add Course");
        System.out.println("3. Drop Course");
        System.out.println("4. View Registered Courses");
        System.out.println("5. Make Payment");
        System.out.println("6. View Grade Card");
        System.out.println("7. View All Courses");
        System.out.println("8. Logout");
        while (true) {
            System.out.print("Please enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Write logic for course registration");
                    break;
                case 2:
                    System.out.print("ENTER COURSE ID: ");
                    String course_code = sc.nextLine();
<<<<<<< HEAD
                    student.addCourse(9, course_code);
=======
                    student.addCourse(userId, course_code);
//                    System.out.println("Write logic for add course");
>>>>>>> d67654c233a6740ca7d5c6081c5718cab0a10b7b
                    break;

                case 3:
                    System.out.print("ENTER COURSE ID: ");
                    course_code = sc.nextLine();
<<<<<<< HEAD
                    student.dropCourse(9, course_code);
=======
                    student.dropCourse(userId, course_code);
//                    System.out.println("Write logic for drop course");
>>>>>>> d67654c233a6740ca7d5c6081c5718cab0a10b7b
                    break;

                case 4:
//                    System.out.println("Write logic for view registered courses");
                    List<String> regCourses = student.viewRegisteredCourses(userId);
                    for (String course : regCourses){
                        System.out.println(course);
                    }
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
                    crsApplication.createMenu();
                    break;

                default:
                    System.out.println("Wrong Selection! Please enter your choice again.");

            }
        }
    }
}
