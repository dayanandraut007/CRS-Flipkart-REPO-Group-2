package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;

import java.util.ArrayList;
import java.util.List;
public class UserImpl implements UserInterface{

    //-------------------HARD CODED------------------------------------
    List users;

    public UserImpl(){
        users = new ArrayList<User>();
        User user1 = new User("007", "daya", "pass", Role.PROFESSOR);
        User user2 = new User("008", "kashish", "pass", Role.ADMIN);
        User user3 = new User("009", "deepak", "pass", Role.STUDENT);
        users.add(user1);
        users.add(user2);
        users.add(user3);

    }



    //-----------------------------------------------------------------
    @Override
    public boolean changePassword(String userID, String newPassword) {
        return false;
    }

    @Override
    public boolean updateDetails(User user) {
        return false;
    }

    @Override
    public boolean login(String userID, String password) {
        return false;
    }
}
