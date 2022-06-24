package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.MockData;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.exception.*;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminImpl implements AdminInterface {

    CourseInterface courseInterface;
    //-------------------HARD CODED------------------------------------
    AdminDaoInterface adminDaoInterface = AdminDaoImpl.getInstance();


    //-----------------------------------------------------------------
    public AdminImpl(){
        courseInterface = new CourseImpl();
    }
    MockData data = MockData.getInstance();
    @Override
    public boolean deleteCourse(String courseCode) throws CourseNotFoundException {
        boolean status = adminDaoInterface.findCourse(courseCode);
        if(!status)
        {
            throw new CourseNotFoundException(courseCode);
        }
        adminDaoInterface.deleteCourse(courseCode);
        return true;
    }

    @Override
    public boolean addCourse(Course course) throws CourseAlreadyPresentException, UserNotFoundException {
        boolean status = adminDaoInterface.findCourse(course.getCourseCode());
        if(status)
        {
            throw new CourseAlreadyPresentException();
        }
        boolean status1 = adminDaoInterface.findUser(course.getInstructor());
        if(!status1)
        {
            throw new UserNotFoundException(course.getInstructor(),"Professor");
        }
        adminDaoInterface.addCourse(course);
        return true;
    }

    @Override
    public List<Student> viewPendingAdmissions() {
        return null;
    }

    @Override
    public void approveStudent() {
        adminDaoInterface.approveStudent();
    }

    @Override
    public void addProfessor(Professor professor) throws UserAlreadyExistException {
        boolean status = adminDaoInterface.findUser(professor.getUserID());
        if(status)
        {
            throw new UserAlreadyExistException(professor.getUserID(),"Professor");
        }
        adminDaoInterface.addProfessor(professor);
    }

    @Override
    public void assignCourse(String courseCode, String professorId) {

    }

    @Override
    public List<Course> viewCourses() {
        return adminDaoInterface.viewCourses();
    }

    @Override
    public List<Professor> viewProfessors() {
        return adminDaoInterface.viewProfessors();
    }

    @Override
    public List<StudentGrade> generateGradeCard(String userId) throws UserNotFoundException {
        boolean status = adminDaoInterface.findUser(userId);
        if(!status)
        {
            throw new UserNotFoundException(userId,"Student");
        }
        return adminDaoInterface.generateScoreCard(userId);
    }

    @Override
    public void notifyCourseChange() {

    }

}
