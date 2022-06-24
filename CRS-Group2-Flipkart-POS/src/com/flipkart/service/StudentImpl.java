package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.dao.*;
import com.flipkart.exception.*;

import java.util.List;



public class StudentImpl implements StudentInterface {


    CourseInterface courseInterface;
    AdminInterface adminInterface;

    StudentDaoInterface studentDaoInterface = StudentDaoImpl.getInstance();
    NotificationDaoInterface notificationDaoInterface = NotificationDaoImpl.getInstance();

    //-----------------------------------------------------------------
    public StudentImpl() {
        courseInterface = new CourseImpl();
        adminInterface = new AdminImpl();
    }


    @Override
    public Student register(String name, String userID, String password, String gender, int batch, String branch, String address) {
        Student stud1 = studentDaoInterface.register(name, userID, password, null, batch, branch, address);
        return stud1;
    }

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

    @Override
    public Student getStudentById(String studentId) {
        return studentDaoInterface.getStudentById(studentId);
    }

    @Override
    public boolean isApproved(String studentId) {
        return studentDaoInterface.isApproved(studentId);
    }

    @Override
    public boolean addCourse(String userId, String courseCode, String primary) throws CourseAlreadyRegisteredException {
        Student std = studentDaoInterface.getStudentById(userId);
        if (std.isHasRegistered()) {
            System.out.println("This course is already added.");
            throw new CourseAlreadyRegisteredException();
        }
        return studentDaoInterface.addCourse(userId, courseCode, primary);

    }

    @Override
    public boolean dropCourse(String userId, String courseCode) throws CourseAlreadyRegisteredException {
        Student std = studentDaoInterface.getStudentById(userId);
        if (std.isHasRegistered()) {
            System.out.println("Already Registered");
            throw new CourseAlreadyRegisteredException();

        }
        return studentDaoInterface.dropCourse(userId, courseCode);
    }

    @Override
    public List<String> viewRegisteredCourses(String userId) {
        return studentDaoInterface.viewRegisteredCourses(userId);
    }

    @Override
    public List<StudentGrade> viewGradeCard(String userId) {
        return studentDaoInterface.viewGradeCard(userId);
    }

    @Override
    public List<String> viewAddedCourses(String userId) {
        return studentDaoInterface.viewAddedCourses(userId);
    }

    @Override
    public List<Course> viewAllCourses() {
        return studentDaoInterface.viewAllCourses();
    }

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
