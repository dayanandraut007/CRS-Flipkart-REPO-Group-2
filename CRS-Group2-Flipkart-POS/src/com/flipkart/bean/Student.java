package com.flipkart.bean;

import com.flipkart.constant.Role;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    private int studentID;
    private String branch;
    private int batch;
    private boolean isApproved;


    private boolean hasRegistered;


    private boolean donePayment;

    private List<String> courses;
    private String address;

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Student() {
        super();
    }
    public Student(String userID, String name, String password, Role role,int studentId,String branch,int batch,
                   boolean isApproved,String address,boolean hasRegistered,boolean donePayment) {
        super(userID, name, password,role);
        this.branch = branch;
        this.studentID = studentId;
        this.batch = batch;
        this.isApproved = isApproved;
        this.address = address;
        this.courses = new ArrayList<>();
        this.hasRegistered = hasRegistered;
        this.donePayment = donePayment;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }


    public String getBranch() {
        return branch;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public boolean isHasRegistered() {
        return hasRegistered;
    }

    public void setHasRegistered(boolean hasRegistered) {
        this.hasRegistered = hasRegistered;
    }

    public boolean isDonePayment() {
        return donePayment;
    }

    public void setDonePayment(boolean donePayment) {
        this.donePayment = donePayment;
    }



}
