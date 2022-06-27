/**
 * @author : jedi2022-Group2
 * projecr : CRS-Group2-Flipkart
 */
package com.flipkart.exception;

public class StudentAlreadyRegisteredException extends Exception {
    public StudentAlreadyRegisteredException(){
        super();
    }

    public  StudentAlreadyRegisteredException(String msg){
        super(msg);
    }
}
