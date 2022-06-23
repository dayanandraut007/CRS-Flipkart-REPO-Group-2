package com.flipkart.exception;

public class PaymentFailedException extends Exception{

    public PaymentFailedException(){
        super("Payment failed");
    }

    public PaymentFailedException(String msg){
        super(msg);
    }
}
