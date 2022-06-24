package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.MockData;
import com.flipkart.exception.GradeNotAddedException;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.ProfessorInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.flipkart.exception.*;

public class ProfessorCRSMenu {

    ProfessorInterface professorInterface = new ProfessorImpl();

    public void addGrade()  {
        try
        {
            System.out.println("ENTER THE COURSE ID FOR WHICH YOU WANT TO ADD GRADE: ");
            Scanner sc = new Scanner(System.in);
            String course = sc.next();
            System.out.println("ENTER THE STUDENT ID: ");
            String sid = sc.next();
            System.out.println("ENTER GRADE: ");
            String gr = sc.next();
            boolean temp =  professorInterface.addGrade(course, sid, gr);
//            if(!temp)
//            {
//                System.out.println("Grade not added.Please try again!0");
//
//            }
        }
        catch (GradeNotAddedException e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void viewAssignedStudent(String userId){

        List<EnrolledStudent> student = professorInterface.viewAssignedStudents(userId);
        for(EnrolledStudent std: student){
            System.out.println(std.getStudentId());
        }
    }

    public void viewTeachingCourses(String userId) {

        List<Course> course = professorInterface.viewTeachingCourses(userId);
        for (Course cs : course) {
            System.out.println("COURSE CODE: " + cs.getCourseCode() + "\tCOURSE NAME: " + cs.getName());
        }
    }

    public void createMenu(String userId) {

        CRSApplication crsApplication = new CRSApplication();

        ProfessorImpl professor = new ProfessorImpl();
        System.out.println("============================================");
        System.out.println("--------------PROFESSOR CRS MENU------------");
        System.out.println("============================================");
        System.out.println("1. View Assigned Courses");
        System.out.println("2. View Enrolled Students");
        System.out.println("3. Add Grade");
        System.out.println("4. Logout");
        while (true) {
            System.out.print("\nPlease enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewTeachingCourses(userId);
                    break;
                case 2:
                    viewAssignedStudent(userId);
                    break;
                case 3:
                    addGrade();
                    break;
                case 4:
                    crsApplication.createMenu();
                    break;

                default:
                    System.out.println("Wrong Selection! Please enter your choice again.");

            }
        }
    }



}
