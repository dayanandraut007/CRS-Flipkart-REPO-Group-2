package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public interface StudentInterface {
    public Student register(String name,String userID,String password,String gender,int batch,
                        String branch,String address);

    public boolean semesterRegistration(String userId);

    public Student getStudentById(String studentId);

    public boolean isApproved(String studentId);

    public boolean addCourse(String userId, String courseCode);
    public boolean dropCourse(String userId, String courseCode);


    List<String> viewRegisteredCourses(String userId);
    List<String> viewAddedCourses(String userId);

    public List<Course> viewAllCourses();
    public boolean makePayment(int studentId);


}
