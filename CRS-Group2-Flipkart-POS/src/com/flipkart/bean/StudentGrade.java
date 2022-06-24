package com.flipkart.bean;

import com.flipkart.constant.Grade;

/**
 * StudentGrade class
 */
public class StudentGrade {
    private String courseCode;
    //private String courseName;
    private Grade grade;
    private String studentID;

    /**
     * Parameterized constructor
     * @param courseCode
     * @param grade
     * @param studentID
     */
    public StudentGrade(String courseCode, Grade grade, String studentID) {
        this.courseCode = courseCode;
        //this.courseName = courseName;
        this.setGrade(grade);
        this.studentID = studentID;
    }

    /**
     * Default constructor
     */
    public StudentGrade(){

    }

    /**
     * Method to get the course code
     * @return course code
     */

    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Method to set course code
     * @param courseCode
     */
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

    /**
     * Method to get grade of the student
     * @return
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * Method to set grade
     * @param grade
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    /**
     * Method to get student id
     * @return student id
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Method to set student id
     * @param studentID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
