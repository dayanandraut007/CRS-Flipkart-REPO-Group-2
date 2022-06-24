package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.exception.CourseAlreadyPresentException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.exception.UserNotFoundException;

/**
 * This interface provides all the Admin functionality implementation.
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

public interface AdminInterface {
    /**
     * Method to delete course
     *
     * @param courseCode
     * @return true if added successfully, else false
     * @throws CourseNotFoundException
     */
    public boolean deleteCourse(String courseCode) throws CourseNotFoundException;

    /**
     * Method to add course in the catalogue
     *
     * @param course
     * @return true if added successfully, else false
     * @throws CourseAlreadyPresentException
     * @throws UserNotFoundException
     */

    public boolean addCourse(Course course) throws CourseAlreadyPresentException, UserNotFoundException;

    /**
     * Method to view Pending admissions
     *
     * @return list of students pending for admission
     */
    public List<Student> viewPendingAdmissions();

    /**
     * Method to approve student for login
     */
    public void approveStudent();

    /**
     * Method to add Professor
     *
     * @param professor
     * @throws UserAlreadyExistException
     */
    public void addProfessor(Professor professor) throws UserAlreadyExistException;

    /**
     * Method to assign course to professor
     *
     * @param courseCode
     * @param professorId
     */
    public void assignCourse(String courseCode, String professorId);

    /**
     * Method to view all courses in the catalogue
     *
     * @return list of courses
     */
    public List<Course> viewCourses();

    /**
     * Method to view all professors
     *
     * @return list of professors
     */
    public List<Professor> viewProfessors();

    /**
     * Method to generate grade card of student
     *
     * @param userId
     * @return list of courses with grades assigned
     * @throws UserNotFoundException
     */
    public List<StudentGrade> generateGradeCard(String userId) throws UserNotFoundException;

    /**
     * Method to notify course change
     */
    public void notifyCourseChange();
}