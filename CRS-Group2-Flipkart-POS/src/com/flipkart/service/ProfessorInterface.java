package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

import java.util.List;

public interface ProfessorInterface {
    public List<Student> viewAssignedStudents();
    public boolean addGrade();
    public List<Course> viewTeachingCourses();

}