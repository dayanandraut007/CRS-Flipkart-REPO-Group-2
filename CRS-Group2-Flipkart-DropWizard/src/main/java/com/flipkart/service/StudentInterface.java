package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.exception.*;

import java.util.List;

/**
 * The StudentInterface interface provides all the necessary Student Functionalities.
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public interface StudentInterface {
    /**
     * Method to register Student
     * @param name
     * @param userID
     * @param password
     * @param batch
     * @param branch
     * @param address
     * @return student object
     */
    public Student register(String name,String userID,String password,int batch,
                        String branch,String address) throws UserAlreadyExistException;
    /**
     * Method for Semester Registration
     * @param userId
     * @return Boolean
     * @throws PaymentFailedException
     * @throws SemesterRegistrationException
     */
    public boolean semesterRegistration(String userId) throws PaymentFailedException, SemesterRegistrationException,StudentAlreadyRegisteredException;
    /**
     * Method to fetch student by Student ID
     * @param studentId : Student Id
     * @return student object
     * @throws UserNotFoundException
     */
    public Student getStudentById(String studentId) throws UserNotFoundException;
    /**
     * Method to check Student Approval
     * @param studentId
     * @return Boolean
     */
    public boolean isApproved(String studentId);

    /** Method to add Course for registration
     * @param userId
     * @param courseCode
     * @param primary
     * @return Boolean
     * @throws CourseAlreadyRegisteredException
     * @throws CourseNotFoundException
     * @throws CourseAlreadyPresentException
     */
    public boolean addCourse(String userId, String courseCode,String primary) throws CourseAlreadyRegisteredException, CourseNotFoundException,CourseAlreadyPresentException,CourseLimitException;
    /**
     * Method to drop Course from Registration
     * @param userId
     * @param courseCode
     * @return Boolean
     * @throws CourseAlreadyRegisteredException
     * @throws CourseNotAddedException
     */
    public boolean dropCourse(String userId, String courseCode) throws CourseAlreadyRegisteredException,CourseNotAddedException;

    /**
     * Method to view all Registered Courses
     * @param userId
     * @return list of courses
     */
    List<String> viewRegisteredCourses(String userId) throws StudentNotRegisteredException;
    /**
     * Method to view Report Card
     * @param userId
     * @return list of grades
     */
    public List<StudentGrade> viewGradeCard(String userId) throws  StudentNotRegisteredException;
    /**
     * Method to view all added Courses
     * @param userId
     * @return list of added courses
     */
    List<List<String>>  viewAddedCourses(String userId);
    /**
     * Method to view all Courses present
     * @return list of all courses
     */
    public List<Course> viewAllCourses();
    /**
     * Method to make payment
     * @param studentId
     * @param transactionId
     * @param modeOfPayment
     * @param amount
     * @return Boolean
     * @throws CourseLimitException
     * @throws PaymentFailedException
     */
    public boolean makePayment(String studentId,String transactionId,String modeOfPayment,float amount) throws CourseLimitException, PaymentFailedException,PaymentAlreadyDoneException;


}
