/**
 * @author : jedi2022-Group2
 * projecr : CRS-Group2-Flipkart
 */
package com.flipkart.exception;

public class StudentNotRegisteredException extends Exception {
    public StudentNotRegisteredException(){
        super();
    }

    public  StudentNotRegisteredException(String msg){
        super(msg);
    }
}
