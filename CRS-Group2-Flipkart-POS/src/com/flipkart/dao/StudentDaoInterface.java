package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;

import java.util.List;

/**
 * The StudentDaoInterface interface provides an interface to interact with the database
 * @author JEDI-June-Program-Group-2-2022
 * @version 1.0
 * since June 2022
 */
public interface StudentDaoInterface {

    /**
     * Method to register student in database
     * @param name: name of student
     * @param userID: user Id of student
     * @param password: password of student
     * @param gender: gender of student
     * @param batch: batch of student
     * @param branch: branch of student
     * @param address: address of student
     * @return
     * {@link Student}
     */
    public Student register(String name, String userID, String password, String gender, int batch,
                            String branch, String address);

    /**
     * Method to do semester registration of the student
     * @param userId
     * {@link Boolean}
     * @return
     */
    public boolean semesterRegistration(String userId);

    /**
     * Method to fetch the details of the student by its ID
     * @param userId
     * {@link Student}
     * @return
     */
    public Student getStudentById(String userId);

    /**
     * Method to check whether admin has approved the student
     * @param studentId
     * {@link Boolean}
     * @return
     * {link Boolean}
     */
    public boolean isApproved(String studentId);

    /**
     * Method to add course for the student
     * @param userId
     * @param courseCode
     * @param primary
     * {@link Boolean}
     * @return
     */
    public boolean addCourse(String userId, String courseCode,String primary);
    /**
     * Method to drop course of the Student
     * @param userId
     * @param courseCode
     * @return
     * {@link Boolean}
     */
    public boolean dropCourse(String userId, String courseCode);

    /**
     * Method to see the list of the courses registered by the student
     * @param userId
     * @return
     * {@link List}
     */
    public List<String> viewRegisteredCourses(String userId);
    /**
     * Method to see list of added courses
     * @param userId
     * @return
     * {@link List}
     */
    public List<String> viewAddedCourses(String userId);

    /**
     * Method to see list of all the courses
     * @return
     * {@link List}
     */
    public List<Course> viewAllCourses();
    /**
     * Method to Check registration eligibility of the student
     * @param userId
     * @return
     * {@link Boolean}
     */
    public boolean checkRegistrationEligibility(String userId);
    /**
     * Method to approve payment of Student
     * @param userId
     * @return
     * {@link Boolean}
     */
    public boolean approvePayment(String userId);
    /**
     * Method to see the grade card of the student
     * @param userId
     * @return
     * {@link List}
     */
    public List<StudentGrade> viewGradeCard(String userId);

    /**
     * method to make payment for the semester
     * @param userId
     * @param transactionId
     * @param modeOfPayment
     * @param amount
     * @return
     * {@link Boolean}
     */
    public boolean makePayment(String userId,String transactionId, String modeOfPayment, float amount);
    /**
     * method to check whether a course has been added or not
     * @param userId
     * @param courseId
     * @return
     * {@link Boolean}
     */
    public boolean courseNotAdded(String userId,String courseId);


}
