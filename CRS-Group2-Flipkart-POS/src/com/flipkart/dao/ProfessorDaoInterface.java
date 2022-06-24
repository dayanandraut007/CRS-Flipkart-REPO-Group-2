package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.StudentCourseNotMatchedException;

import java.util.List;

/**
 * ProfessorDaoImpl interface is used to implements the Professor database operations
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

public interface ProfessorDaoInterface {

    /**
     * viewAssignedStudents method is used by the professor to view all the students in respective courses
     * @param professorId
     * @return {@link List<EnrolledStudent>}
     */

    public List<EnrolledStudent> viewAssignedStudents(String professorId);

    /**
     * addGrade method is used by the professor to add the grade to the student for particular course
     * @param userId
     * @param courseId
     * @param studentId
     * @param grade
     * @return {@link boolean}
     * @throws CourseNotAssignedToProfessorException
     * @throws StudentCourseNotMatchedException
     *
     */
    public boolean addGrade(String userId,String courseId, String studentId, String grade);

    /**
     * viewTeachingCourses method is used by the professor to view all the courses assigned to him
     * @param professorId
     * @return {@link List<Course>}
     */
    public List<Course> viewTeachingCourses(String professorId);

    /**
     * getProfessorById method is used to fetch the details of professor by getting id from database
     * @param professorId
     * @return {@link Professor}
     */
    public Professor getProfessorById(String professorId);

    /**
     * courseAssignedToProfessor method is used to check whether professor is assigned to respective course or not.
     * @param userId
     * @param courseId
     * @return boolean
     */
    public boolean courseAssignedToProfessor(String userId, String courseId);
}
