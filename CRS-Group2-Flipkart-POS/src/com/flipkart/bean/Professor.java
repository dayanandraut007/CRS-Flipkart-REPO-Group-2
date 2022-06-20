package com.flipkart.bean;

import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

import java.util.Date;

public class Professor extends User{
    private String department;
    private String designation;
    private Date dateOfJoining;
    private Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    public Professor(String userID, String name, String password, Role role,String department,Gender gender,String designation,Date dateOfJoining,String address) {
        super(userID, name, password, role);
        this.department = department;
        this.designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.gender = gender;
        this.address = address;
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
