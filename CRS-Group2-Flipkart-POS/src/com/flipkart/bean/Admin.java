package com.flipkart.bean;

import com.flipkart.constant.Role;

import java.util.Date;

public class Admin extends User{

    private Date dateOfJoining;

    public Date getDateOfJoining() {
        return dateOfJoining;
    }



    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }




    public Admin(String userID, String name, String password, Role role,Date dateOfJoining) {
        super(userID, name, password, role);
        this.dateOfJoining = dateOfJoining;
    }
}
