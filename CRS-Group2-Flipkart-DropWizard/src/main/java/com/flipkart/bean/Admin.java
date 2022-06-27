package com.flipkart.bean;

import com.flipkart.constant.Role;

import java.util.Date;

/**
 * Admin Class
 */
public class Admin extends User{

    private Date dateOfJoining;

    /**
     * Method to get Date of Joining
     * @return Date of Joining
     */
    public Date getDateOfJoining() {
        return dateOfJoining;
    }


    /**
     * Method to set Date of Joining
     * @param dateOfJoining: Date of Joining
     */
    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    /**
     * Parameterized constructor
     * @param userID: user Id
     * @param name: username
     * @param password: user password
     * @param role: role of user
     * @param dateOfJoining: Date of Joining
     */

    public Admin(String userID, String name, String password, Role role,Date dateOfJoining) {
        super(userID, name, password, role);
        this.dateOfJoining = dateOfJoining;
    }
}
