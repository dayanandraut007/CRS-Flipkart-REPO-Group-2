package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.List;

/**
 * CourseImpl interface is used to implement the Course service operations
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

public interface CourseInterface {

    /**
     * getCourseById method returns the course details
     * @param courseCode
     * @return {@Link Course}
     */

    public Course getCourseById(String courseCode);

    /**
     * viewAllCourses method return all the courses
     * @return {@Link List<Course>}
     */
    public List<Course> viewAllCourses();




}
