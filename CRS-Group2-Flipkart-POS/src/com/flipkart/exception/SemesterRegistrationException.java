package com.flipkart.exception;

public class SemesterRegistrationException extends  Exception{

    public SemesterRegistrationException(){
        super();
    }

    public  SemesterRegistrationException(String msg){
        super(msg);
    }
}
