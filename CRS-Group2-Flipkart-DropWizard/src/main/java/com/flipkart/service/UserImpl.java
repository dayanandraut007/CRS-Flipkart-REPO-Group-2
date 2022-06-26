package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDaoImpl;
import com.flipkart.dao.UserDaoInterface;

/**
 * Implementation for User Service operations
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class UserImpl implements UserInterface{

    UserDaoInterface userDaoInterface = UserDaoImpl.getInstance();

    //-----------------------------------------------------------------

    /**
     * changePassword method is used to change the password
     * @param userID
     * @param newPassword
     * return boolean
     */
    @Override
    public boolean changePassword(String userID, String newPassword) {
        return userDaoInterface.changePassword(userID,newPassword);

    }

    /**
     * UpdateDetails method will update the details of user
     * @param user
     * return boolean
     */
    @Override
    public boolean updateDetails(User user) {
        return false;
    }

    /**
     * User Login method uses SQL commands and verifies the user
     * @param userID
     * @param password
     * return User
     */

    @Override
    public User login(String userID, String password){

        User usr = userDaoInterface.login(userID,password);
        return usr;
    }
}
