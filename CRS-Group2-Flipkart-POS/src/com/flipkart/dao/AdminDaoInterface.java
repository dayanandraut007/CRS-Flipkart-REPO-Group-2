package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;

import java.util.List;

/**
        * This interface provides all the Admin  functionality for Admin Dao Implementation.
         *
         * @author  JEDI-June-Program-Group-2-2022
        * @version 1.0
        * @since   June 2022
        */

public interface AdminDaoInterface {

    /**
     * Method to delete course from the catalog
     * @param courseCode
     * @return
     */
    public boolean deleteCourse(String courseCode);

    /**
     * Method to add course to the catalog
     * @param course
     * @return
     */
    public boolean addCourse(Course course);

    /**
     * Method to view pending admission of the students
     * @return
     */
    public List<Student> viewPendingAdmissions();

    /**
     * Method to approve new students for login
     */
    public void approveStudent();

    /**
     * Method to add new professor
     * @param professor
     */
    public void addProfessor(Professor professor);

    /**
     * Method to assign course to professor
     * @param courseCode
     * @param professorId
     */
    public void assignCourse(String courseCode, String professorId);

    /**
     * Method to view courses in the catalogue
     * @return list of courses
     */
    public List<Course> viewCourses();

    /**
     * Method to view all professors
     * @return list of professors
     */
    public List<Professor> viewProfessors();


    /**
     * Method to generate grade card
     * @param studentId
     * @return list of course with grades
     */
    public List<StudentGrade> generateScoreCard(String studentId);

    /**
     * Method to notify changes
     */
    public void notifyCourseChange();

    /**
     * Method to find if course exist
     * @param courseCode
     * @return true if exist, false otherwise
     */
    public boolean findCourse(String courseCode);
    /**
     * Method to check if user exists or not
     * @param userId
     * @return true if exist, false otherwise
     */
    public boolean findUser(String userId);
}
