package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

import java.util.List;

public interface AdminDaoInterface {
    public boolean deleteCourse(String courseCode);

    public boolean addCourse(Course course);
    public List<Student> viewPendingAdmissions();
    public void approveStudent();
    public void addProfessor(Professor professor);
    public void assignCourse(String courseCode, String professorId);
    public List<Course> viewCourses();
    public List<Professor> viewProfessors();
    public void notifyCourseChange();
}
