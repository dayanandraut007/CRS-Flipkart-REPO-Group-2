/**
 *
 */
package com.flipkart.exception;


public class CourseLimitException extends Exception{

    public CourseLimitException(){
        super("4 primary courses and 2 optional courses must be added in order to register for the semester");
    }

    public CourseLimitException(String msg){
        super(msg);
    }


}