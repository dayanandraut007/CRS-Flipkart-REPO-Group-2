package com.flipkart.bean;

/**
 * EnrolledStudent class
 */
public class EnrolledStudent {
    private String courseCode;
    private String courseName;
    private String studentId;
    private String primary;

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    /**
     * Method to get the course code
     * @return course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Method to set the course code
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Method to get the course name
     * @return course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Method to set the course name
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Method to get the student id
     * @return student id
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * Method to set the student id
     * @param studentId
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * Parameterized constructor
     * @param courseCode
     * @param courseName
     * @param studentId
     */
    public EnrolledStudent(String courseCode, String courseName, String studentId) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.studentId = studentId;
    }

    /**
     * Default constructor
     */
    public  EnrolledStudent(){}
}
