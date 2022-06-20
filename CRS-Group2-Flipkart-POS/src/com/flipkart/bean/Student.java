package com.flipkart.bean;

public class Student extends User{
    private int studentID;
    private String studentName;
    private String branch;
    private int batch;

    public Student(String userID, String name, String password, String address, String country) {
        super(userID, name, password, address, country);
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBranch() {
        return branch;
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


}
