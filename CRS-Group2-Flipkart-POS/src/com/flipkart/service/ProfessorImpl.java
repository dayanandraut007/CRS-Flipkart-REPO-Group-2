package com.flipkart.service;

import com.flipkart.bean.*;
import com.flipkart.dao.MockData;
import com.flipkart.dao.ProfessorDaoImpl;
import com.flipkart.dao.ProfessorDaoInterface;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.StudentCourseNotMatchedException;
import com.flipkart.exception.UserNotFoundException;

import java.util.List;

/**
 * ProfessorImpl class implements the Professor service operations
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */


public class ProfessorImpl implements ProfessorInterface {

    //----------HARD CODED------------------
    MockData data = MockData.getInstance();



    //-------------------------------------

    ProfessorDaoInterface professorDaoInterface = ProfessorDaoImpl.getInstance();

    /**
     * viewAssignedStudents method is used by the professor to view all the students in respective courses
     * @param professorId
     * @return list of enrolled students
     */

    @Override
    public List<EnrolledStudent> viewAssignedStudents(String professorId) {

       return professorDaoInterface.viewAssignedStudents(professorId);
    }

    /**
     * addGrade method is used by the professor to add the grade to the student for particular course
     * @param userId
     * @param courseId
     * @param studentId
     * @param grade
     * @return boolean
     * @throws CourseNotAssignedToProfessorException
     * @throws StudentCourseNotMatchedException
     *
     */



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

    /**
     * viewTeachingCourses method is used by the professor to view all the courses assigned to him
     * @param professorId
     * @return list of view teaching courses
     */

    @Override
    public List<Course> viewTeachingCourses(String professorId) {
        return professorDaoInterface.viewTeachingCourses(professorId);
    }

    /**
     * getProfessorById method is used to fetch the professor details
     * @param professorId
     * @return
     * @throws UserNotFoundException
     * @return professor object
     */

    @Override
    public Professor getProfessorById(String professorId) throws UserNotFoundException {

        Professor std = professorDaoInterface.getProfessorById(professorId);
        if(std == null){
            throw new UserNotFoundException(professorId,"professor");
        }
        return std;
    }


}
