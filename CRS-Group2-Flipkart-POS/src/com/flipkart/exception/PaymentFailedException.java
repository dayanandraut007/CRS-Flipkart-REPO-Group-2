package com.flipkart.exception;

/**
 * Exception class for Payment failed
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class PaymentFailedException extends Exception{

    public PaymentFailedException(){
        super("Payment failed");
    }

    public PaymentFailedException(String msg){
        super(msg);
    }
}
