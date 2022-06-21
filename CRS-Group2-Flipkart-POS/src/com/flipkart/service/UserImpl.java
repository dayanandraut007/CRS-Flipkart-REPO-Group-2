package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.dao.MockData;

import java.util.ArrayList;
import java.util.List;
public class UserImpl implements UserInterface{

    //-------------------HARD CODED------------------------------------
    MockData data = MockData.getInstance();

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
    public Role login(String userID, String password){

        for(User usr:data.users){
            if(usr.getUserID().equals(userID) && usr.getPassword().equals(password)) return usr.getRole();
        }
        return null;
    }
}
