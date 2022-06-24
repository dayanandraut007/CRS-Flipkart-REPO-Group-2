package com.flipkart.exception;


public class GradeNotAddedException extends Exception{

    private String studentId;

    /**
     * Constructor
     * @param studentId
     */
    public GradeNotAddedException(String studentId)
    {
        System.out.println("Grade not added! Please try again.");
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