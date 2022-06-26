package com.flipkart.bean;

/**
 * Payment class
 */
public class Payment {
    private String studentID;
    private float amount;
    private String transactionId;
    private String paymentMethod;

    /**
     * Parameterized constructor
     * @param studentID
     * @param amount
     * @param paymentMethod
     * @param transactionId
     */
    public Payment(String studentID, float amount, String paymentMethod, String transactionId) {
        this.studentID = studentID;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
    }

    public Payment() {
    }

    /**
     * Method to get payment method
     * @return payment method
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Method to set the payment method
     * @param paymentMethod
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Method to get the transaction id for the payment
     * @return transaction id
     */
    public String getTransactionId() { return transactionId; }

    /**
     * Method to set the transaction id for the payment
     * @param transactionId
     */
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }

    /**
     * Method to get the student id
     * @return student id
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Method to set the student id
     * @param studentID
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
     * Method to get the amount
     * @return amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Method to set amount
     * @param amount
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }





}
