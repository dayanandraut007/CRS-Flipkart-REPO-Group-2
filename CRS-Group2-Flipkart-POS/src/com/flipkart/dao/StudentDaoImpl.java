package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class StudentDaoImpl implements StudentDaoInterface{
    private static StudentDaoImpl instance = null;
    private PreparedStatement statement = null;
    private StudentDaoImpl(){}

    public static StudentDaoImpl getInstance()
    {
        if(instance == null)
        {
            instance = new StudentDaoImpl();
        }
        return instance;
    }

    Connection connection = DBUtils.getConnection();

    @Override
    public Student register(String name, String userID, String password, String gender, int batch, String branch, String address) {
        return null;
    }

    @Override
    public boolean semesterRegistration(String userId) {
        return false;
    }

    @Override
    public Student getStudentById(int studentId) {
        return null;
    }

    @Override
    public boolean isApproved(int studentId) {
        return false;
    }

    @Override
    public boolean addCourse(String userId, String courseCode) {
        return false;
    }

    @Override
    public boolean dropCourse(String userId, String courseCode) {
        return false;
    }

    @Override
    public List<String> viewRegisteredCourses(String userId) {
        return null;
    }

    @Override
    public List<Course> viewAllCourses() {
        return null;
    }

    @Override
    public boolean makePayment(int studentId) {
        return false;
    }
}
