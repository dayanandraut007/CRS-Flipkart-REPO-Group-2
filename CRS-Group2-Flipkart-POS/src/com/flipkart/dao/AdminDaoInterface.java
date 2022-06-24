package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;

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

    public List<StudentGrade> generateScoreCard(String studentId);
    public void notifyCourseChange();
    public boolean findCourse(String courseCode);
    public boolean findUser(String courseCode);
}
