package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.dao.MockData;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.dao.UserDaoInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for User Service operations
 */
public class UserImpl implements UserInterface{

    //-------------------HARD CODED------------------------------------
    MockData data = MockData.getInstance();
    UserDaoInterface userDaoInterface = UserDaoImpl.getInstance();

    //-----------------------------------------------------------------

    /**
     * changePassword method is used to change the password
     * @param userID
     * @param newPassword
     * @return {@Link Boolean}
     */
    @Override
    public boolean changePassword(String userID, String newPassword) {
        return false;
    }

    /**
     * UpdateDetails method will update the details of user
     * @param user
     * @return {@Link boolean}
     */
    @Override
    public boolean updateDetails(User user) {
        return false;
    }

    /**
     * User Login method uses SQL commands and verifies the user
     * @param userID
     * @param password
     * @return {@link User}
     */

    @Override
    public User login(String userID, String password){

        User usr = userDaoInterface.login(userID,password);
        return usr;
    }
}
