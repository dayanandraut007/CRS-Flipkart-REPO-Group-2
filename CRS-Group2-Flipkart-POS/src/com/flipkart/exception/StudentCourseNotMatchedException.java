package com.flipkart.exception;


public class StudentCourseNotMatchedException extends Exception{

    private String studentId;

    /**
     * Constructor
     * @param studentId
     */
    public StudentCourseNotMatchedException(String studentId)
    {
        System.out.println("Student is not enrolled in this course. Grade not added.");
        this.studentId = studentId;
    }

    /**
     * Getter function for studentId
     * @return
     */
    public String getStudentId()
    {
        return studentId;
    }


}