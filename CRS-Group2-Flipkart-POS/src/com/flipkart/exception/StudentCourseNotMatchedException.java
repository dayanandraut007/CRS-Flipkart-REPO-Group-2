package com.flipkart.exception;

/**
 * Exception class for student course not matched
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

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