package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.Grade;
import com.flipkart.exception.GradeNotAddedException;

import java.util.List;

public interface ProfessorInterface {
    public List<EnrolledStudent> viewAssignedStudents(String professorId);
    public boolean addGrade(String courseId, String studentId, String grade) throws GradeNotAddedException;
    public List<Course> viewTeachingCourses(String professorId);

    public Professor getProfessorById(String professorId);



}