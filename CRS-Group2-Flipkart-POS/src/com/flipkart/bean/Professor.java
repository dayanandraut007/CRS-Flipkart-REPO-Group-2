package com.flipkart.bean;

import java.util.Date;

public class Professor extends User{
    private String department;
    private String designation;
    private Date dateOfJoining;

    public Professor(String userID, String name, String password, String address, String country) {
        super(userID, name, password, address, country);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }


}
