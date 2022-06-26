/**
 * @author : jedi2022-Group2
 * projecr : CRS-Group2-Flipkart
 */
package com.flipkart.exception;

public class PaymentAlreadyDoneException extends Exception{
    public PaymentAlreadyDoneException(){
        super();
    }

    public  PaymentAlreadyDoneException(String msg){
        super(msg);
    }
}
