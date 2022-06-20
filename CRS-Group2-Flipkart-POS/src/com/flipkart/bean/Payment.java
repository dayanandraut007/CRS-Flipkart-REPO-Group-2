package com.flipkart.bean;

public class Payment {
    private int studentID;
    private float amount;

    public Payment(int studentID, float amount, boolean status) {
        this.studentID = studentID;
        this.amount = amount;
        this.status = status;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private boolean status;



}
