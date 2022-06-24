package com.flipkart.service;

import java.util.List;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;

public interface AdminInterface {
    public boolean deleteCourse(String courseCode);

    public boolean addCourse(Course course);
    public List<Student> viewPendingAdmissions();
    public void approveStudent();
    public void addProfessor(Professor professor);
    public void assignCourse(String courseCode, String professorId);
    public List<Course> viewCourses();
    public List<Professor> viewProfessors();
    public List<StudentGrade> generateGradeCard(String userId);
    public void notifyCourseChange();
}