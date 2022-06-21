package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.dao.MockData;

import java.util.ArrayList;
import java.util.List;

public class CourseImpl implements  CourseInterface{

    //------------Hardcoded-------------------

    MockData data = MockData.getInstance();
    //----------------------------------------

    @Override
    public Course getCourseById(String courseCode) {

        for(Course csr:data.courses){
            if(csr.getCourseCode().equals(courseCode) ) return csr;
        }

        return null;
    }

    @Override
    public List<Course> viewAllCourses() {
        return data.courses;
    }




}
