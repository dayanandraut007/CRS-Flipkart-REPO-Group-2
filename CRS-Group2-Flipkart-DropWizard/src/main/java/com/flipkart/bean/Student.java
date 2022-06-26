package com.flipkart.bean;

import com.flipkart.constant.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Student class
 */
public class Student extends User{
    private String branch;
    private int batch;
    private boolean isApproved;


    private boolean hasRegistered;


    private boolean donePayment;

    private String address;

    /**
     * Method to check whether the student is approved or not
     * @return boolean value for whether the student is approved or no
     */
    public boolean isApproved() {
        return isApproved;
    }

    /**
     * Method to approve the student
     * @param approved
     */
    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    /**
     * Method to get the address of the student
     * @return address of the student
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method to set the address of the student
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * Super constructor
     */
    public Student() {
        super();
    }

    /**
     * Parameterized constructor
     * @param userID
     * @param name
     * @param password
     * @param role
     * @param branch
     * @param batch
     * @param isApproved
     * @param address
     * @param hasRegistered
     * @param donePayment
     */
    public Student(String userID, String name, String password, Role role,String branch,int batch,
                   boolean isApproved,String address,boolean hasRegistered,boolean donePayment) {
        super(userID, name, password,role);
        this.branch = branch;
        this.batch = batch;
        this.isApproved = isApproved;
        this.address = address;
        this.hasRegistered = hasRegistered;
        this.donePayment = donePayment;
    }



    /**
     * Method to get branch of the student
     * @return branch of the student
     */
    public String getBranch() {
        return branch;
    }


    /**
     * Method to set branch of the student
     * @param branch
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * Method to get batch of the student
     * @return batch of the student
     */
    public int getBatch() {
        return batch;
    }

    /**
     * Method to set batch of the student
     * @param batch
     */
    public void setBatch(int batch) {
        this.batch = batch;
    }

    /**
     * Method to check whether the student has registered or not
     * @return boolean value whether the student has registered or not
     */
    public boolean isHasRegistered() {
        return hasRegistered;
    }

    /**
     * Method to set the student registered
     * @param hasRegistered
     */
    public void setHasRegistered(boolean hasRegistered) {
        this.hasRegistered = hasRegistered;
    }

    /**
     * Method to check whether the student has made payment or not
     * @return boolean value for payment status
     */
    public boolean isDonePayment() {
        return donePayment;
    }

    /**
     * Method to set payment status of the student
     * @param donePayment
     */
    public void setDonePayment(boolean donePayment) {
        this.donePayment = donePayment;
    }



}
