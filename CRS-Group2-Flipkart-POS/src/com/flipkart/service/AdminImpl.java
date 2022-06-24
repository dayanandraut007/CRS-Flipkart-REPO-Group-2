package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;
import com.flipkart.dao.MockData;

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
    public boolean deleteCourse(String courseCode) {
        adminDaoInterface.deleteCourse(courseCode);
        return true;
    }

    @Override
    public boolean addCourse(Course course) {
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
    public void addProfessor(Professor professor) {
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
    public List<StudentGrade> generateGradeCard(String userId) {
        return adminDaoInterface.generateScoreCard(userId);
    }

    @Override
    public void notifyCourseChange() {

    }

}
