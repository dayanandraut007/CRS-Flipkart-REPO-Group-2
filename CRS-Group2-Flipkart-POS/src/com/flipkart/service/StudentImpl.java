package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Role;
import com.flipkart.dao.*;

import java.util.List;

public class StudentImpl implements StudentInterface {


    CourseInterface courseInterface;
    AdminInterface adminInterface;

    StudentDaoInterface studentDaoInterface = StudentDaoImpl.getInstance();
    NotificationDaoInterface notificationDaoInterface = NotificationDaoImpl.getInstance();

    //-----------------------------------------------------------------
    public StudentImpl(){
        courseInterface = new CourseImpl();
        adminInterface = new AdminImpl();
    }



    @Override
    public Student register(String name, String userID, String password, String gender, int batch, String branch, String address) {
        Student stud1 = studentDaoInterface.register(name,userID,password,null,batch,branch,address);
        return stud1;
    }

    @Override
    public boolean semesterRegistration(String userId) {
        Student std = studentDaoInterface.getStudentById(userId);
        if(!std.isDonePayment()){
            System.out.println("Kindly perform payment of fess to proceed to registration");
            return false;
        }
        boolean status = studentDaoInterface.semesterRegistration(userId);
        if(!status){
            System.out.println("Server Error. Problem Encountered");
            return false;
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
    public boolean addCourse(String userId ,String courseCode,String primary) {
        Student std = studentDaoInterface.getStudentById(userId);
        if(std.isHasRegistered()){
            System.out.println("Already Registered");
            return false;
        }
        return studentDaoInterface.addCourse(userId,courseCode,primary);

    }

    @Override
    public boolean dropCourse(String userId, String courseCode) {
        Student std = studentDaoInterface.getStudentById(userId);
        if(std.isHasRegistered()){
            System.out.println("Already Registered");
            return false;
        }
        return studentDaoInterface.dropCourse(userId,courseCode);
    }

    @Override
    public List<String> viewRegisteredCourses(String userId) {
        return studentDaoInterface.viewRegisteredCourses(userId);
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
    public boolean makePayment(String studentId,String transactionId,String modeOfPayment,float amount) {
        boolean st = studentDaoInterface.checkRegistrationEligibility(studentId);
        if(!st){
            System.out.println("Courses not eligible.");
            return false;
        }
        boolean status = studentDaoInterface.makePayment(studentId,transactionId,modeOfPayment,amount);
        if(status){
            String message = transactionId + ": Payment of amount " + amount + " done successfully by " + studentId;
            System.out.println(message);
            notificationDaoInterface.sendNotification(studentId,message);
            boolean st1 = studentDaoInterface.approvePayment(studentId);
            if(!st1){
                System.out.println("Payment not Approved");
                return false;
            }
            System.out.println("Payment Approved");
            return true;

        }else{
            System.out.println("Error Encountered. Payment Failed");
        }
        return false;
    }
}
