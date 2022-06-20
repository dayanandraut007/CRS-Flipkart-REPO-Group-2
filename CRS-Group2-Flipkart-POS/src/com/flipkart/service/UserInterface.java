package com.flipkart.service;

import com.flipkart.bean.User;

public interface UserInterface {

    public boolean changePassword(String userID, String newPassword);

    public boolean updateDetails(User user);

    public boolean login(String userID,String password);

}
