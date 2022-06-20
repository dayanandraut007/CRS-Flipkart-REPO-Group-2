package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public interface StudentInterface {
    public int register(String name,String userID,String password,String gender,int batch,
                        String branch,String address,String country);

    public Student getStudentById(int studentId);

    public boolean isApproved(int studentId);

    public boolean addCourse(int studentId, String courseCode);
    public boolean dropCourse(int studentId, String courseCode);

    public List<Course> viewRegisteredCourses(int studentId);

    public float calculateFees(int studentId);


}
