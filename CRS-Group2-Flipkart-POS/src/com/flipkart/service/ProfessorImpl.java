package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.MockData;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.StudentCourseNotMatchedException;
import com.flipkart.exception.UserNotFoundException;

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
    public boolean addGrade(String userId,String courseId, String studentId, String grade) throws CourseNotAssignedToProfessorException,StudentCourseNotMatchedException {

        boolean temp1 = professorDaoInterface.courseAssignedToProfessor(userId,courseId);
        if(!temp1){
            throw new CourseNotAssignedToProfessorException(courseId,userId);
        }
        boolean temp = professorDaoInterface.addGrade(userId,courseId, studentId, grade);
        if(!temp)
        {
            throw new StudentCourseNotMatchedException(studentId);
        }

        return temp;


    }

    @Override
    public List<Course> viewTeachingCourses(String professorId) {
        return professorDaoInterface.viewTeachingCourses(professorId);
    }

    @Override
    public Professor getProfessorById(String professorId) throws UserNotFoundException {

        Professor std = professorDaoInterface.getProfessorById(professorId);
        if(std == null){
            throw new UserNotFoundException(professorId,"student");
        }
        return std;
    }


}
