package com.flipkart.exception;

/**
 * Exception class for semester registration
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class SemesterRegistrationException extends  Exception{

    public SemesterRegistrationException(){
        super();
    }

    public  SemesterRegistrationException(String msg){
        super(msg);
    }
}
