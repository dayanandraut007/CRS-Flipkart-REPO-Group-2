/**
 *
 */
package com.flipkart.exception;

/**
 * Exception to check if course is already registered by student
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class CourseAlreadyPresentException extends Exception {

    /**
     * Message returned when exception is thrown
     */
    public CourseAlreadyPresentException(){
        super("This course is already added.");
    }


    public CourseAlreadyPresentException(String msg){
        super();
    }
}