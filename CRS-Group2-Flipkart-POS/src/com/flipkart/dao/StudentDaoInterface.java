package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public interface StudentDaoInterface {

    public Student register(String name, String userID, String password, String gender, int batch,
                            String branch, String address);

    public boolean semesterRegistration(String userId);

    public Student getStudentById(String userId);

    public boolean isApproved(String studentId);

    public boolean addCourse(String userId, String courseCode,String primary);
    public boolean dropCourse(String userId, String courseCode);


    public List<String> viewRegisteredCourses(String userId);
    public List<String> viewAddedCourses(String userId);

    public List<Course> viewAllCourses();
    public boolean checkRegistrationEligibility(String userId);
    public boolean approvePayment(String userId);

    public boolean makePayment(String userId,String transactionId, String modeOfPayment, float amount);


}
