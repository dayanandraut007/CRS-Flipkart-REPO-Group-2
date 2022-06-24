package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.StudentCourseNotMatchedException;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.ProfessorInterface;

import java.util.List;
import java.util.Scanner;
/**
 * Menu class for Professor
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class ProfessorCRSMenu {

    ProfessorInterface professorInterface = new ProfessorImpl();

    /**
     * Methdod to add grade
     * @param userId
     */
    public void addGrade(String userId)  {
        try
        {
            System.out.println("ENTER THE COURSE ID FOR WHICH YOU WANT TO ADD GRADE: ");
            Scanner sc = new Scanner(System.in);
            String course = sc.next();
            System.out.println("ENTER THE STUDENT ID: ");
            String sid = sc.next();
            System.out.println("ENTER GRADE: ");
            String gr = sc.next();
            boolean temp =  professorInterface.addGrade(userId,course, sid, gr);
//            if(!temp)
//            {
//                System.out.println("Grade not added.Please try again!0");
//
//            }
        }
        catch (StudentCourseNotMatchedException | CourseNotAssignedToProfessorException e)
        {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Method to view assigned student
     * @param userId
     */
    public void viewAssignedStudent(String userId){

        List<EnrolledStudent> student = professorInterface.viewAssignedStudents(userId);
        for(EnrolledStudent std: student){
            System.out.println(std.getStudentId());
        }
    }

    /**
     * Method to view teaching courses
     * @param userId
     */
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
                    addGrade(userId);
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
