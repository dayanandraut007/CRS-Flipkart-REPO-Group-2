package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.constant.Grade;
import com.flipkart.dao.MockData;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.exception.GradeNotAddedException;

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
    public boolean addGrade(String courseId, String studentId, String grade) throws GradeNotAddedException  {

        boolean temp = professorDaoInterface.addGrade(courseId, studentId, grade);
        if(!temp)
        {
            throw new GradeNotAddedException(studentId);
        }

        return temp;


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
