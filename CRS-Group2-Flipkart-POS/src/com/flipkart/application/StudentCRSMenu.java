package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.exception.*;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.UserImpl;
import com.flipkart.service.UserInterface;
import com.sun.corba.se.spi.orbutil.fsm.Input;
import javafx.util.Pair;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Menu class for Student
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class StudentCRSMenu {

    CRSApplication crsApplication = new CRSApplication();
    StudentInterface studentInterface=new StudentImpl();
    UserInterface userInterface=new UserImpl();
    Scanner sc = new Scanner(System.in);

    /**
     * Method for course registration
     * @param userId
     */
    public void courseRegistration(String userId){
        try {
            Student std = studentInterface.getStudentById(userId);
            if(std.isHasRegistered()){
                System.out.println("Already Registered");
                return;
            }
            boolean status = studentInterface.semesterRegistration(userId);
            if (status) {
                System.out.println("Final Registration done");
            }
        }
        catch(PaymentFailedException | SemesterRegistrationException | UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to view added course
     * @param userId
     */
    public void viewAddedCourses(String userId){
        List<Pair<String,Boolean>>  regCourses = studentInterface.viewAddedCourses(userId);
        System.out.println("Course Code ------------ Primary/Optional");
        for (Pair<String,Boolean>  course : regCourses){
            String st="optional";
            if(course.getValue()){
                st="Primary";
            }
            System.out.println(course.getKey() + " -------- " + st);
        }
    }

    /**
     * Method to make payment
     * @param userId
     */
    public void makePayment(String userId){
        try {
            Student std = studentInterface.getStudentById(userId);
            if(std.isDonePayment() && std.isHasRegistered()){
                System.out.println("Payment Already Done and Registered");
                return;
            }
            if(std.isDonePayment()){
                System.out.println("Payment Done. Proceed to register");
                return;
            }
            System.out.print("ENTER paymentMethod: ");
            String paymentMethod = sc.next();
            SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
            String transactionId = date.format(new Date());
            studentInterface.makePayment(userId, paymentMethod, transactionId, 5000);
        }
        catch(CourseLimitException | PaymentFailedException | UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to add course
     * @param userId
     */
    public void addCourse(String userId){
        try {
            Student std = studentInterface.getStudentById(userId);
            if(std.isHasRegistered()){
                System.out.println("Already Registered. Add/Drop not allowed now.");
                return;
            }
            List<Pair<String,Boolean>>  regCourses = studentInterface.viewAddedCourses(userId);
            if(regCourses.size() >=6){
                System.out.println("6 courses already registered. Can't add more. Drop a course to add new");
                return;
            }
            System.out.print("ENTER COURSE ID: ");
            String course_code = sc.next();
            System.out.print("Primary(Y/N): ");
            String primary = sc.next();
            boolean status = studentInterface.addCourse(userId, course_code, primary);
            if (!status) {
                System.out.println("Can't Register");
            }
        }
        catch(CourseAlreadyRegisteredException | CourseNotFoundException | CourseAlreadyPresentException | UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to drop course
     * @param userId
     */
    public void dropCourse(String userId){
        try{
            Student std = studentInterface.getStudentById(userId);
            if(std.isHasRegistered()){
                System.out.println("Already Registered. Add/Drop not allowed now.");
                return;
            }
            System.out.print("ENTER COURSE ID: ");
            String course_code = sc.next();
            boolean status2 = studentInterface.dropCourse(userId, course_code);
            if(!status2){
                System.out.println("Already Registered. Can't add or drop now");
            }
        }
        catch(CourseAlreadyRegisteredException | CourseNotAddedException | UserNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to view grade card
     * @param userId
     */

    public void viewGradeCard(String userId){
        List<StudentGrade> gradeList= studentInterface.viewGradeCard(userId);
        System.out.println("Course ---------- Grade" );
        gradeList.forEach(gc->{
            System.out.println(gc.getCourseCode() + "----------"  + gc.getGrade().toString() );
        });

    }

    /**
     * Method to change Password for the student
     * @param userId
     */

    public void changePassword(String userId){
        System.out.print("Enter new Password: ");
        String newPassword = sc.next();
        if(userInterface.changePassword(userId,newPassword)){
            System.out.println("Password Changed Successfully");
        }else{
            System.out.println("Not changed");
        }
    }

    public void viewRegisteredCourses(String userId){
        List<String> regCourses = studentInterface.viewRegisteredCourses(userId);
        if(regCourses.size() == 0){
            System.out.println("Registration not completed. You can view your added courses in View Added Courses section");
        }
        for (String course : regCourses){
            System.out.println(course);
        }
    }


    public void createMenu(String userId){
        try {
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
            System.out.println("8. View Added Courses");
            System.out.println("9. Change Password");
            System.out.println("10. Logout");
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
                        addCourse(userId);

                        break;

                    case 3:
                        dropCourse(userId);


                        break;

                    case 4:
                        //                    System.out.println("Write logic for view registered courses");
                        viewRegisteredCourses(userId);
                        break;

                    case 5:
                        makePayment(userId);
                        break;

                    case 6:
                        viewGradeCard(userId);
                        break;

                    case 7:

                        List<Course> course = studentInterface.viewAllCourses();
                        for (Course cs : course) {
                            System.out.println(cs.getCourseCode());

                        }
                        break;

                    case 8:
                        viewAddedCourses(userId);
                        break;

                    case 9:
                        changePassword(userId);
                        break;

                    case 10:
                        crsApplication.createMenu();
                        break;

                    default:
                        System.out.println("Wrong Selection! Please enter your choice again.");

                }
            }
        }
        catch(InputMismatchException e) {

            System.out.println("Wrong input format");
            createMenu(userId);
        }
    }
}
