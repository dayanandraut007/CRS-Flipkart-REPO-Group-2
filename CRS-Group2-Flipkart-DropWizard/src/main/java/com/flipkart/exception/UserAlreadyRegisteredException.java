/**
 * @author : jedi2022-Group2
 * projecr : CRS-Group2-Flipkart
 */
package com.flipkart.exception;

public class UserAlreadyRegisteredException extends Exception {
    public UserAlreadyRegisteredException(){
        super();
    }

    public  UserAlreadyRegisteredException(String msg){
        super(msg);
    }
}
