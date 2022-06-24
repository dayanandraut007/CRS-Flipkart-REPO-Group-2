package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.exception.*;

import java.util.List;

public interface StudentInterface {
    public Student register(String name,String userID,String password,String gender,int batch,
                        String branch,String address);

    public boolean semesterRegistration(String userId) throws PaymentFailedException, SemesterRegistrationException;

    public Student getStudentById(String studentId) throws UserNotFoundException;

    public boolean isApproved(String studentId);

    public boolean addCourse(String userId, String courseCode,String primary) throws CourseAlreadyRegisteredException, CourseNotFoundException,CourseAlreadyPresentException;
    public boolean dropCourse(String userId, String courseCode) throws CourseAlreadyRegisteredException,CourseNotAddedException;


    List<String> viewRegisteredCourses(String userId);
    public List<StudentGrade> viewGradeCard(String userId);
    List<String> viewAddedCourses(String userId);

    public List<Course> viewAllCourses();
    public boolean makePayment(String studentId,String transactionId,String modeOfPayment,float amount) throws CourseLimitException, PaymentFailedException;


}
