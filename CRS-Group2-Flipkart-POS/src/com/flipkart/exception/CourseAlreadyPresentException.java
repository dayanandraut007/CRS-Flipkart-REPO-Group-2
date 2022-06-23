/**
 *
 */
package com.flipkart.exception;


public class CourseAlreadyPresentException extends Exception {
    private String courseCode;

    /***
     * Constructor
     * @param courseCode
     */
    public CourseAlreadyPresentException(String courseCode) {
        this.courseCode = courseCode;
    }


    /**
     * Getter method
     *
     * @return course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "Course with courseCode: " + courseCode + " already present in catalog.";
    }
}