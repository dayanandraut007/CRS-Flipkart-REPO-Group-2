/**
 * @author : jedi2022-Group2
 * projecr : CRS-Group2-Flipkart
 */
package com.flipkart.exception;

/**
 * Exception class for course not added
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class CourseNotAddedException extends Exception{

    public CourseNotAddedException(){
        super("This course is not added by you.");
    }

    public CourseNotAddedException(String msg){
        super();
    }
}
