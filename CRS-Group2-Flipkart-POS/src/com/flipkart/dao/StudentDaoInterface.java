package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import javafx.util.Pair;

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
     * @return student
     */
    public Student register(String name, String userID, String password, String gender, int batch,
                            String branch, String address);

    /**
     * Method to do semester registration of the student
     * @param userId
      * return  Boolean
     */
    public boolean semesterRegistration(String userId);

    /**
     * Method to fetch the details of the student by its ID
     * @param userId
     *
     * @return true or false
     */
    public Student getStudentById(String userId);

    /**
     * Method to check whether admin has approved the student
     * @param studentId
     * @return Boolean
     */
    public boolean isApproved(String studentId);

    /**
     * Method to add course for the student
     * @param userId
     * @param courseCode
     * @param primary

     * @return
     */
    public boolean addCourse(String userId, String courseCode,String primary);
    /**
     * Method to drop course of the Student
     * @param userId
     * @param courseCode
     * @return boolean
     */
    public boolean dropCourse(String userId, String courseCode);

    /**
     * Method to see the list of the courses registered by the student
     * @param userId
     * @return true or false
     */
    public List<String> viewRegisteredCourses(String userId);
    /**
     * Method to see list of added courses
     * @param userId
     * @return list of registered courses
     */
    public List<Pair<String,Boolean>>  viewAddedCourses(String userId);

    /**
     * Method to see list of all the courses
     * @return list of all courses
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
     * @return boolean
     */
    public boolean approvePayment(String userId);
    /**
     * Method to see the grade card of the student
     * @param userId
     * @return list of grades
     */
    public List<StudentGrade> viewGradeCard(String userId);

    /**
     * method to make payment for the semester
     * @param userId
     * @param transactionId
     * @param modeOfPayment
     * @param amount
     * @return boolean payment status
     */
    public boolean makePayment(String userId,String transactionId, String modeOfPayment, float amount);
    /**
     * method to check whether a course has been added or not
     * @param userId
     * @param courseId
     * @return boolean
     */
    public boolean courseNotAdded(String userId,String courseId);


}
