package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.dao.MockData;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.dao.UserDaoInterface;

import java.util.ArrayList;
import java.util.List;
public class UserImpl implements UserInterface{

    //-------------------HARD CODED------------------------------------
    MockData data = MockData.getInstance();
    UserDaoInterface userDaoInterface = UserDaoImpl.getInstance();

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
    public User login(String userID, String password){

        User usr = userDaoInterface.login(userID,password);
        return usr;
    }
}
