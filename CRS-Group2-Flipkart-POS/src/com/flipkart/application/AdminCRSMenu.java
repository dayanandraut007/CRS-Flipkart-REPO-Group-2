package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.dao.MockData;
import com.flipkart.exception.CourseAlreadyPresentException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;

import java.util.*;

/**
 * Menu class for Admin
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class AdminCRSMenu {

    AdminInterface adminInterface = new AdminImpl();
    CRSApplication crsApplication = new CRSApplication();
    Scanner sc = new Scanner(System.in);

    MockData data = MockData.getInstance();

    /**
     * Method to add course
     */
    public void addCourse(){
        List<Student> st = new ArrayList<>();

        System.out.print("COURSE CODE: ");
        String courseCode = sc.next();
        System.out.print("COURSE NAME: ");
        String name = sc.next();
        System.out.print("COURSE INSTRUCTOR: ");
        String instructor = sc.next();
        System.out.print("COURSE PREREQUISITES: ");
        String prerequisites = sc.next();
        System.out.print("NUMBER OF SEATS: ");
        int seats = sc.nextInt();
        Course newCourse= new Course(courseCode,name,true,instructor,prerequisites,seats,st);
        try
        {
            adminInterface.addCourse(newCourse);
        }
        catch(CourseAlreadyPresentException | UserNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Method to delete course
     */
    public void deleteCourse(){
        System.out.print("Please enter the course code to be deleted: ");
        String courseCodeDelete = sc.next();
        try
        {
            adminInterface.deleteCourse(courseCodeDelete);
        }
        catch(CourseNotFoundException e)
        {
            System.out.println(e.getMessage());

        }

    }

    /**
     * Method to generate scorecard
     */
    public void generateScoreCard(){
        try
        {
            System.out.print("Enter student id to generate score card: ");
            String id = sc.next();
            List<StudentGrade> gradeList = adminInterface.generateGradeCard(id);
            System.out.println("Course ---------- Grade" );
            gradeList.forEach(gc->{
                System.out.println(gc.getCourseCode() + "----------"  + gc.getGrade().toString() );
            });

        }
        catch (UserNotFoundException e)
        {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Method to add professor
     */
    public void addProfessor(){
        System.out.print("USER ID: ");
        String userId = sc.next();

        System.out.print("NAME: ");
        String name = sc.next();

        System.out.print("DEPARTMENT: ");
        String department = sc.next();
        System.out.println("DESIGNATION: ");
        String designation= sc.next();
        System.out.print("ADDRESS: ");
        String address = sc.next();
        System.out.print("GENDER: ");
        String gender = sc.next();

        Professor newProfessor = new Professor(userId,name,"pass",Role.PROFESSOR,0,department,Gender.valueOf(gender.toUpperCase()),designation,new Date(),address);
        try{
            adminInterface.addProfessor(newProfessor);
        }
        catch(UserAlreadyExistException e)
        {
            System.out.println(e.getMessage());
        }


    }

    /**
     * Method to approve student
     */
    public void approveStudents(){
        adminInterface.approveStudent();
    }

    public void createMenu() {
        try {
            System.out.println("============================================");
            System.out.println("----------------ADMIN CRS MENU-------------");
            System.out.println("============================================");
            System.out.println("1. View All Courses");
            System.out.println("2. View All Professors");
            System.out.println("3. Add new Course to Course Catalog");
            System.out.println("4. Delete a Course from Course Catalog");
            System.out.println("5. Add Professor to CRS");
            System.out.println("6. Approve Registration of Students");
            System.out.println("7. Generate Grade Card for Students");
            System.out.println("8. Logout");
            while (true) {
                System.out.print("Enter your choice: ");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        List<Course> course = adminInterface.viewCourses();
                        for (Course cs : course) {
                            System.out.println(cs.getCourseCode());
                            for (Student std : cs.getEnrolled()) {
                                System.out.println(std.getUserID());
                            }
                        }
                        break;
                    case 2:
                        List<Professor> professor = adminInterface.viewProfessors();
                        for (Professor ps : professor) {
                            System.out.println("PROFESSOR ID: " + ps.getUserID() + ",  PROFESSOR NAME: " + ps.getName());
                        }
                        break;
                    case 3:
                        addCourse();
                        break;

                    case 4:
                        deleteCourse();
                        break;

                    case 5:
                        addProfessor();
                        break;

                    case 6:
                        approveStudents();
                        break;

                    case 7:
                        generateScoreCard();
                        break;
                    case 8:
                        crsApplication.createMenu();
                        break;

                    default:
                        System.out.println("Wrong Selection! Please enter your choice again.");

                }

            }
        }
        catch(InputMismatchException e){
            System.out.println("Input format misMatched");
            createMenu();
        }
    }
}
