package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;

public interface UserInterface {

    public boolean changePassword(String userID, String newPassword);

    public boolean updateDetails(User user);

    public User login(String userID, String password);

}
