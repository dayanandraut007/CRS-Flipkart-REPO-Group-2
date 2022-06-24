package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.dao.*;
import com.flipkart.exception.*;

import java.util.List;

/**
 * The StudentImpl class implements the StudentInterface interface
 * to provide all the Student functionality implementations.
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class StudentImpl implements StudentInterface {


    CourseInterface courseInterface;
    AdminInterface adminInterface;

    StudentDaoInterface studentDaoInterface = StudentDaoImpl.getInstance();
    AdminDaoInterface adminDaoInterface = AdminDaoImpl.getInstance();
    NotificationDaoInterface notificationDaoInterface = NotificationDaoImpl.getInstance();

    //-----------------------------------------------------------------
    public StudentImpl() {
        courseInterface = new CourseImpl();
        adminInterface = new AdminImpl();
    }


    /**
     * Method to register Student
     * @param name
     * @param userID
     * @param password
     * @param gender
     * @param batch
     * @param branch
     * @param address
     * @return student object
     */
    @Override
    public Student register(String name, String userID, String password, String gender, int batch, String branch, String address) throws UserAlreadyExistException {
        boolean status = adminDaoInterface.findUser(userID);
        if (status) {
            throw new UserAlreadyExistException(userID, "Student");
        }
        Student stud1 = studentDaoInterface.register(name, userID, password, null, batch, branch, address);
        return stud1;
    }

    /**
     * Method for Semester Registration
     * @param userId
     * @return Boolean
     * @throws PaymentFailedException
     * @throws SemesterRegistrationException
     */
    @Override
    public boolean semesterRegistration(String userId) throws PaymentFailedException, SemesterRegistrationException {
        Student std = studentDaoInterface.getStudentById(userId);
        if (!std.isDonePayment()) {
            System.out.println("Kindly perform payment of fess to proceed to registration");
            throw new PaymentFailedException("Failed to register because payment is pending");

        }
        boolean status = studentDaoInterface.semesterRegistration(userId);
        if (!status) {
            throw new SemesterRegistrationException("Failed to register for the semester");

        }
        System.out.println("Successfully Registered");
        return true;

    }

    /**
     * Method to fetch student by Student ID
     * @param studentId : Student Id
     * @return student object
     * @throws UserNotFoundException
     */
    @Override
    public Student getStudentById(String studentId) throws UserNotFoundException {
        Student std = studentDaoInterface.getStudentById(studentId);
        if(std == null){
            throw new UserNotFoundException(studentId,"student");
        }
        return std;
    }


    /**
     * Method to check Student Approval
     * @param studentId
     * @return Boolean
     */
    @Override
    public boolean isApproved(String studentId) {
        return studentDaoInterface.isApproved(studentId);
    }

    /** Method to add Course for registration
     * @param userId
     * @param courseCode
     * @param primary
     * @return Boolean
     * @throws CourseAlreadyRegisteredException
     * @throws CourseNotFoundException
     * @throws CourseAlreadyPresentException
     */
    @Override
    public boolean addCourse(String userId, String courseCode, String primary) throws CourseAlreadyRegisteredException,CourseNotFoundException,CourseAlreadyPresentException {
        Student std = studentDaoInterface.getStudentById(userId);
        if (std.isHasRegistered()) {
            throw new CourseAlreadyRegisteredException();
        }
        boolean status = adminDaoInterface.findCourse(courseCode);
        if(!status){
            throw new CourseNotFoundException(courseCode);
        }
        if(studentDaoInterface.courseNotAdded(userId,courseCode)){
            throw new CourseAlreadyPresentException();
        }
        return studentDaoInterface.addCourse(userId, courseCode, primary);

    }

    /**
     * Method to drop Course from Registration
     * @param userId
     * @param courseCode
     * @return Boolean
     * @throws CourseAlreadyRegisteredException
     * @throws CourseNotAddedException
     */
    @Override
    public boolean dropCourse(String userId, String courseCode) throws CourseAlreadyRegisteredException,CourseNotAddedException {
        Student std = studentDaoInterface.getStudentById(userId);
        if (std.isHasRegistered()) {
            throw new CourseAlreadyRegisteredException();

        }
        if(!studentDaoInterface.courseNotAdded(userId,courseCode)){
            throw new CourseNotAddedException();
        }
        return studentDaoInterface.dropCourse(userId, courseCode);
    }

    /**
     * Method to view all Registered Courses
     * @param userId
     * @return list of registered courses
     */
    @Override
    public List<String> viewRegisteredCourses(String userId) {
        return studentDaoInterface.viewRegisteredCourses(userId);
    }

    /**
     * Method to view Report Card
     * @param userId
     * @return list of grades
     */
    @Override
    public List<StudentGrade> viewGradeCard(String userId) {
        return studentDaoInterface.viewGradeCard(userId);
    }

    /**
     * Method to view all added Courses
     * @param userId
     * @return list of added courses
     */
    @Override
    public List<String> viewAddedCourses(String userId) {
        return studentDaoInterface.viewAddedCourses(userId);
    }

    /**
     * Method to view all Courses present
     * @return list of all courses
     */
    @Override
    public List<Course> viewAllCourses() {
        return studentDaoInterface.viewAllCourses();
    }

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
    @Override
    public boolean makePayment(String studentId, String transactionId, String modeOfPayment, float amount) throws CourseLimitException, PaymentFailedException {
        boolean st = studentDaoInterface.checkRegistrationEligibility(studentId);
        if (!st) {
            System.out.println("Courses not eligible.");
            throw new CourseLimitException();
        }
        boolean status = studentDaoInterface.makePayment(studentId, transactionId, modeOfPayment, amount);
        if (!status) throw new PaymentFailedException("Payment Failed.");

        String message = transactionId + ": Payment of amount " + amount + " done successfully by " + studentId;
        System.out.println(message);
        notificationDaoInterface.sendNotification(studentId, message);
        boolean st1 = studentDaoInterface.approvePayment(studentId);
        if (!st1) {
            System.out.println("Payment not Approved");
            throw new PaymentFailedException("Payment not approved.");

        }
        System.out.println("Payment Approved");
        return true;

    }
}
