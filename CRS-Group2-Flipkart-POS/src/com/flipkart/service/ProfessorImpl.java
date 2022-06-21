package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.Grade;
import com.flipkart.dao.MockData;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ProfessorImpl implements ProfessorInterface {

    //----------HARD CODED------------------
    MockData data = MockData.getInstance();



    //-------------------------------------
    @Override
    public void viewAssignedStudents(int professorId) {
        String pname;
        List<Course> crs = new ArrayList<>();
        for(Professor prf : data.professors){
            if(prf.getProfessorId() == professorId){
                pname=prf.getName();
                for(Course crs1 : data.courses) {
                    if (crs1.getInstructor().equals(pname)) {
                        System.out.println("COURSE ID: " + crs1.getCourseCode() + "\t COURSE NAME: " + crs1.getName() );
                        System.out.println("ENROLLED STUDENTS: ");
                        for (Student st1 : crs1.getEnrolled()) {
                            System.out.print(st1.getStudentID()+"."+st1.getName() + "\t");
                        }
                        System.out.println();

                    }
                }

            }
        }
       return ;
    }

    @Override
    public boolean addGrade(int studentId, Grade grade, String courseCode) {
        System.out.println("BATCH DETAILS:\n");
        viewAssignedStudents(007);
        System.out.println("ENTER THE COURSE ID FOR WHICH YOU WANT TO ADD GRADE: ");
        Scanner sc=new Scanner(System.in);
        String course = sc.next();

        System.out.println("ENTER THE STUDENT ID: ");
        int sid = sc.nextInt();
        System.out.println("ENTER GRADE: ");
        String gr = sc.next();
        StudentGrade studentGrades = new StudentGrade(course,Grade.valueOf(gr.toUpperCase()),sid);



        return false;
    }

    @Override
    public List<Course> viewTeachingCourses(int professorId) {
        String pname;
        List<Course> crs = new ArrayList<>();
        for(Professor prf : data.professors){
            if(prf.getProfessorId() == professorId){
             pname=prf.getName();
            for(Course crs1 : data.courses)
                {
                    if(crs1.getInstructor().equals(pname)){

                        crs.add(crs1);
                    }
                }

            }
        }
        return crs;
    }

    @Override
    public Professor getProfessorById(int professorId) {
        return null;
    }


}
