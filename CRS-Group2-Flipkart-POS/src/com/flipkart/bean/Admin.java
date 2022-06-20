package com.flipkart.bean;

import java.util.Date;

public class Admin extends User{
    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    private Date dateOfJoining;


    public Admin(String userID, String name, String password, String address, String country) {
        super(userID, name, password, address, country);
    }
}
