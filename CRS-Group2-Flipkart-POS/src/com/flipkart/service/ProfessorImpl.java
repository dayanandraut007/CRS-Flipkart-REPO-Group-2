package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.constant.Grade;
import com.flipkart.dao.MockData;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.ProfessorDaoInterface;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ProfessorImpl implements ProfessorInterface {

    //----------HARD CODED------------------
    MockData data = MockData.getInstance();



    //-------------------------------------

    ProfessorDaoInterface professorDaoInterface = ProfessorDaoImpl.getInstance();
    @Override
    public List<EnrolledStudent> viewAssignedStudents(String professorId) {

       return professorDaoInterface.viewAssignedStudents(professorId);
    }

    @Override
    public boolean addGrade(String courseId, String studentId, String grade){
//        System.out.println("BATCH DETAILS:");
//        viewAssignedStudents("007");
//        System.out.println("ENTER THE COURSE ID FOR WHICH YOU WANT TO ADD GRADE: ");
//        Scanner sc=new Scanner(System.in);
//        String course = sc.next();
//
//        System.out.println("ENTER THE STUDENT ID: ");
//        int sid = sc.nextInt();
//        System.out.println("ENTER GRADE: ");
//        String gr = sc.next();
//        StudentGrade studentGrades = new StudentGrade(course,Grade.valueOf(gr.toUpperCase()),sid);
//        data.grade.add(studentGrades);
//        System.out.println("GRADE ADDED SUCCESSFULLY!");
//        for(StudentGrade sg: data.grade){
//            System.out.println(sg.getCourseCode()+"\t"+sg.getStudentID()+"\t"+sg.getGrade()+"\n");
//        }

        return professorDaoInterface.addGrade(courseId, studentId, grade);

    }

    @Override
    public List<Course> viewTeachingCourses(String professorId) {
        return professorDaoInterface.viewTeachingCourses(professorId);
    }

    @Override
    public Professor getProfessorById(String professorId) {
        return null;
    }


}
