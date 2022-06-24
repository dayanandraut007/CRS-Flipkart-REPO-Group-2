/**
 * @author : jedi2022-Group2
 * projecr : CRS-Group2-Flipkart
 */
package com.flipkart.exception;

public class CourseNotAddedException extends Exception{

    public CourseNotAddedException(){
        super("This course is not added by you.");
    }

    public CourseNotAddedException(String msg){
        super();
    }
}
