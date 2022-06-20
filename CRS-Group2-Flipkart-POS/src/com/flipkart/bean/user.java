package com.flipkart.bean;

public class user {
    private String userID;
    private String name;
    private String password;
    private String address;
    private String country;

    public user(String userID, String name, String password, String address, String country) {
        this.userID = userID;
        this.name = name;
        this.password = password;
        this.address = address;
        this.country = country;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
