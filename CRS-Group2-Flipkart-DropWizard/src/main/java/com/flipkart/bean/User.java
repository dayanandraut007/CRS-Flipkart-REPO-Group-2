package com.flipkart.bean;

import com.flipkart.constant.Role;

/**
 * User class
 */
public class User {
    private String userID;
    private String name;
    private String password;

    /**
     * Method to set role of the user
     * @return role of the user
     */
    public Role getRole() {
        return role;
    }

    /**
     * Method to set the role of the user
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    private Role role;

    /**
     * Default constructor
     */
    public User() {

    }

    /**
     * Parameterized constructor
     * @param userID
     * @param name
     * @param password
     * @param role
     */
    public User(String userID, String name, String password, Role role) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    /**
     * Method to get the user id
     * @return user id
     */
    public String getUserID() {
        return userID;
    }

    /**
     * Method to set the user id
     * @param userID
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * Method to get name of the user
     * @return name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set the name of the user
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get password of the user
     * @return password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method to set password of the user
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
