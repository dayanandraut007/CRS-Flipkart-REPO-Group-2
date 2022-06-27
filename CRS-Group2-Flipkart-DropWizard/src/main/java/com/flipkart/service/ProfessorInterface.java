package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.StudentCourseNotMatchedException;
import com.flipkart.exception.UserNotFoundException;

import java.util.List;

/**
 * ProfessorImpl interface is used to implement the Professor service operations
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

public interface ProfessorInterface {

    /**
     * viewAssignedStudents method is used by the professor to view all the students in respective courses
     * @param professorId
     * @return list of enrolled students
     */
    public List<EnrolledStudent> viewAssignedStudents(String professorId);

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

    public boolean addGrade(String userId, String courseId, String studentId, String grade) throws CourseNotAssignedToProfessorException,StudentCourseNotMatchedException;

    /**
     * viewTeachingCourses method is used by the professor to view all the courses assigned to him
     * @param professorId
     * @return list of available courses
     */

    public List<Course> viewTeachingCourses(String professorId);

    /**
     * getProfessorById method is used to fetch the professor details
     * @param professorId
     * @return
     * @throws UserNotFoundException
     * @return professor object
     */

    public Professor getProfessorById(String professorId) throws UserNotFoundException;



}