package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.StudentCourseNotMatchedException;
import com.flipkart.exception.UserNotFoundException;

import java.util.List;

public interface ProfessorInterface {
    public List<EnrolledStudent> viewAssignedStudents(String professorId);
    public boolean addGrade(String userId, String courseId, String studentId, String grade) throws CourseNotAssignedToProfessorException,StudentCourseNotMatchedException;
    public List<Course> viewTeachingCourses(String professorId);

    public Professor getProfessorById(String professorId) throws UserNotFoundException;



}