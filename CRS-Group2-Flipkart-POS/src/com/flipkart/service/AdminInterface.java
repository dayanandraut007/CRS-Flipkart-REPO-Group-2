package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.exception.CourseAlreadyPresentException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.exception.UserNotFoundException;

public interface AdminInterface {
    public boolean deleteCourse(String courseCode) throws CourseNotFoundException;

    public boolean addCourse(Course course) throws CourseAlreadyPresentException, UserNotFoundException;
    public List<Student> viewPendingAdmissions();
    public void approveStudent();
    public void addProfessor(Professor professor) throws UserAlreadyExistException;
    public void assignCourse(String courseCode, String professorId);
    public List<Course> viewCourses();
    public List<Professor> viewProfessors();
    public List<StudentGrade> generateGradeCard(String userId) throws UserNotFoundException;
    public void notifyCourseChange();
}