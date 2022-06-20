package com.flipkart.bean;

import com.flipkart.constant.Grade;

public class StudentGrade {
    private String courseCode;
    private String courseName;
    private Grade grade;
    private int studentID;

    public StudentGrade(String courseCode, String courseName, Grade grade, int studentID) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.setGrade(grade);
        this.studentID = studentID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
}
