package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;

import java.util.List;
import java.util.Scanner;

public class StudentCRSMenu {

    CRSApplication crsApplication = new CRSApplication();
    StudentInterface studentInterface=new StudentImpl();

    public void courseRegistration(String userId){
        boolean status = studentInterface.semesterRegistration(userId);
        if(!status){
            System.out.println("Please add 6 courses to register");
        }else{
            System.out.println("Registration Successful. Kindly proceed to payment to complete enrollment");
        }
    }

    public void createMenu(String userId){

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
                    courseRegistration(userId);
                    break;
                case 2:
                    System.out.print("ENTER COURSE ID: ");
                    String course_code = sc.nextLine();
                    boolean status = studentInterface.addCourse(userId, course_code);
                    if(!status){
                        System.out.println("Already Registered. Can't add or drop now");
                    }

                    break;

                case 3:
                    System.out.print("ENTER COURSE ID: ");
                    course_code = sc.nextLine();
                    boolean status2 = studentInterface.dropCourse(userId, course_code);
                    if(!status2){
                        System.out.println("Already Registered. Can't add or drop now");
                    }


                    break;

                case 4:
//                    System.out.println("Write logic for view registered courses");
                    List<String> regCourses = studentInterface.viewRegisteredCourses(userId);
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

                    List<Course> course = studentInterface.viewAllCourses();
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
