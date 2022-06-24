package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.StudentCourseNotMatchedException;
import com.flipkart.service.ProfessorImpl;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.UserImpl;
import com.flipkart.service.UserInterface;

import java.util.List;
import java.util.Scanner;
/**
 * Menu class for Professor
 * This class implements the Professor Course Registration System Menu
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

public class ProfessorCRSMenu {

    ProfessorInterface professorInterface = new ProfessorImpl();
    UserInterface userInterface=new UserImpl();
    Scanner sc = new Scanner(System.in);


    /**
     * Method to add the grade of the student of the particular course the professor is teaching
     * @param userId
     */

    public void addGrade(String userId)  {
        try
        {
            System.out.println("ENTER THE COURSE ID FOR WHICH YOU WANT TO ADD GRADE: ");
            String course = sc.next();
            System.out.println("ENTER THE STUDENT ID: ");
            String sid = sc.next();
            System.out.println("ENTER GRADE: ");
            String gr = sc.next();
            boolean temp =  professorInterface.addGrade(userId,course, sid, gr);

        }
        catch (StudentCourseNotMatchedException | CourseNotAssignedToProfessorException e)
        {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Method to view the students who have enrolled for the course professor is teaching
     * @param userId
     */

    public void viewAssignedStudent(String userId){

        List<EnrolledStudent> student = professorInterface.viewAssignedStudents(userId);
        student.forEach(s->{
            System.out.println(s.getStudentId());
        });
    }

    /**
     * Method to get list of all courses Professor has to teach
     * @param userId
     */

    public void viewTeachingCourses(String userId) {

        List<Course> courses = professorInterface.viewTeachingCourses(userId);
        courses.forEach(c->{
            System.out.println("COURSE CODE: " + c.getCourseCode() + "\tCOURSE NAME: " + c.getName());
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


    /**
     * Method to create professor menu
     * @param userId
     * returns displays all the operations for the professor, and provides navigation
     */

    public void createMenu(String userId) {

        CRSApplication crsApplication = new CRSApplication();

        ProfessorImpl professor = new ProfessorImpl();
        System.out.println("============================================");
        System.out.println("--------------PROFESSOR CRS MENU------------");
        System.out.println("============================================");
        System.out.println("1. View Assigned Courses");
        System.out.println("2. View Enrolled Students");
        System.out.println("3. Add Grade");
        System.out.println("4. Change Password");
        System.out.println("5. Logout");
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
                    changePassword(userId);
                    break;
                case 5:
                    crsApplication.createMenu();
                    break;

                default:
                    System.out.println("Wrong Selection! Please enter your choice again.");

            }
        }
    }



}
