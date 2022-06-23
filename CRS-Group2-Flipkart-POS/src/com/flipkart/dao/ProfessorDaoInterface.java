package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.bean.Professor;

import java.util.List;

public interface ProfessorDaoInterface {
    public List<EnrolledStudent> viewAssignedStudents(String professorId);
    public boolean addGrade(String courseId, String studentId, String grade);
    public List<Course> viewTeachingCourses(String professorId);

    public Professor getProfessorById(String professorId);
}
