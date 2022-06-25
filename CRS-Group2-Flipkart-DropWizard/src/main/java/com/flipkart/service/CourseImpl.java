package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.dao.MockData;

import java.util.ArrayList;
import java.util.List;

/**
 * CourseImpl class implements the Course service operations
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

public class CourseImpl implements  CourseInterface{

    //------------Hardcoded-------------------

    MockData data = MockData.getInstance();
    //----------------------------------------

    /**
     * getCourseById method returns the course details
     * @param courseCode
     * @return course object
     */

    @Override
    public Course getCourseById(String courseCode) {

        for(Course csr:data.courses){
            if(csr.getCourseCode().equals(courseCode) ) return csr;
        }

        return null;
    }

    /**
     * viewAllCourses method return all the courses
     * @return list of courses
     */

    @Override
    public List<Course> viewAllCourses() {
        return data.courses;
    }




}
