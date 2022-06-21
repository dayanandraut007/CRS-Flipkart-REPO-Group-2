package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.MockData;
import com.flipkart.service.ProfessorImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessorCRSMenu {

    public void createMenu() {

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
                    List<Course> course = professor.viewTeachingCourses(007);
                    for(Course cs: course){
                        System.out.println("COURSE CODE: "+cs.getCourseCode()+"\tCOURSE NAME: "+cs.getName());
                    }
                    break;
                case 2:
                    professor.viewAssignedStudents(007);
                    break;
                case 3:
                    professor.addGrade();
                    break;
                case 4:
                    System.out.println("logout");
                    break;

                default:
                    System.out.println("Wrong Selection! Please enter your choice again.");

            }
        }
    }



}
