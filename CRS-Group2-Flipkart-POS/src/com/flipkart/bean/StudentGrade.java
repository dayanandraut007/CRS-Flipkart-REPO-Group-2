package com.flipkart.bean;

import com.flipkart.constant.Grade;

public class StudentGrade {
    private String courseCode;
    //private String courseName;
    private Grade grade;
    private String studentID;

    public StudentGrade(String courseCode, Grade grade, String studentID) {
        this.courseCode = courseCode;
        //this.courseName = courseName;
        this.setGrade(grade);
        this.studentID = studentID;
    }

    public StudentGrade(){

    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

//    public String getCourseName() {
//        return courseName;
//    }
//
//    public void setCourseName(String courseName) {
//        this.courseName = courseName;
//    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
