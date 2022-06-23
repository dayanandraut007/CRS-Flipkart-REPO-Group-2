package com.flipkart.dao;

import com.flipkart.bean.User;

public interface UserDaoInterface {

    public boolean changePassword(String userID, String newPassword);

    public boolean updateDetails(User user);

    public User login(String userID, String password);
}
