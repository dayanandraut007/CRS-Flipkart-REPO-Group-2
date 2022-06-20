package com.flipkart.service;

import com.flipkart.bean.Course;

import java.util.List;

public interface SemesterRegistrationInterface {

    public boolean registerCourses(int studentId, List<Course> registeredCourseList);
    public boolean addCourse(int studentId, String courseCode, List<Course> courseList);
    public boolean dropCourse(int studentId, String courseCode, List<Course> registeredCourseList);
    public float showFees(int studentId);
    public List<Course> viewAllCourses();
    public List<Course> viewRegisteredCourses(int studentId);

}

