package com.flipkart.service;

public interface UserInterface {

    boolean changePassword(String userID, String newPassword);

    public boolean updateDetails(String userID, String name, String address );

    public boolean verifyCredentials(String userID,String password);

}
