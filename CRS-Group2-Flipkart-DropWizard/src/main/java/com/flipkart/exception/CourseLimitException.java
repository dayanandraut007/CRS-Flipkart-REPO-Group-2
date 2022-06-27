/**
 *
 */
package com.flipkart.exception;

/**
 * Exception class for course limit exceeded
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class CourseLimitException extends Exception{

    public CourseLimitException(){
        super("4 primary courses and 2 optional courses must be added in order to register for the semester. Kindly see View Added courses to see your Primary and Optional Courses.");
    }

    public CourseLimitException(String msg){
        super(msg);
    }


}