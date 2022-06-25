/**
 *
 */
package com.flipkart.exception;

/**
 * Exception class for course not deleted
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class CourseNotDeletedException extends Exception{
    private String courseCode;

    public CourseNotDeletedException(String courseCode)
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
     * Message thrown by exception
     */
    @Override
    public String getMessage()
    {
        return "Course with courseCode: " + courseCode + " can not be deleted.";
    }
}