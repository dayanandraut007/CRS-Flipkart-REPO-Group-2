package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.Grade;

import java.util.List;

public interface ProfessorInterface {
    public void viewAssignedStudents(int professorId);
    public boolean addGrade(int studentId, Grade grade,String courseCode);
    public List<Course> viewTeachingCourses(int professorId);

    public Professor getProfessorById(int professorId);



}