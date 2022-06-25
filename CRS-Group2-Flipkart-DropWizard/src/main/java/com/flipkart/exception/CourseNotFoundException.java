package com.flipkart.exception;


/**
 * Exception class for course not found
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class CourseNotFoundException extends Exception{
    private String courseCode;

    public CourseNotFoundException(String courseCode)
    {
        this.courseCode = courseCode;
    }

    /**
     * Getter function for course code
     * @return
     */
    public String getCourseCode()
    {
        return courseCode;
    }


    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage()
    {
        return "Course with courseCode: " + courseCode + " not found.";
    }
}