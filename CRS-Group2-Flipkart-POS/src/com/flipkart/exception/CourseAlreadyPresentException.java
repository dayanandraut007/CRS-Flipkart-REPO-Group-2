/**
 *
 */
package com.flipkart.exception;


public class CourseAlreadyPresentException extends Exception {
    public CourseAlreadyPresentException(){
        super("This course is already added.");
    }

    public CourseAlreadyPresentException(String msg){
        super();
    }
}