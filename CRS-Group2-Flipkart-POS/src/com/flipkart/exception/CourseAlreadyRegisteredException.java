package com.flipkart.exception;


public class CourseAlreadyRegisteredException extends Exception {

    public CourseAlreadyRegisteredException() {
        super("This student has already registered");
    }

    public CourseAlreadyRegisteredException(String msg) {
        super(msg);
    }


}