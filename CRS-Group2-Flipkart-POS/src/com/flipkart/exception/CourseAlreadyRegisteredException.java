package com.flipkart.exception;

/**
 * Exception class for already registered course
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

public class CourseAlreadyRegisteredException extends Exception {

    /**
     * message return for already registered course exception
     */
    public CourseAlreadyRegisteredException() {
        super("This student has already registered");
    }

    public CourseAlreadyRegisteredException(String msg) {
        super(msg);
    }


}