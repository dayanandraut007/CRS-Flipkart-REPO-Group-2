package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.List;

public interface CourseInterface {

    public Course getCourseById(String courseCode);
    public List<Course> viewAllCourses();
}
