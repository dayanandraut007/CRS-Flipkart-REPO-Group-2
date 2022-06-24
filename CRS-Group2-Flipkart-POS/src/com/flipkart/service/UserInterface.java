package com.flipkart.service;

import com.flipkart.bean.User;
import com.flipkart.constant.Role;

/**
 * User Interface used for implementation of User Service operations
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

public interface UserInterface {

    /**
     * changePassword method is used to change the password
     * @param userID
     * @param newPassword
     * return boolean
     */

    public boolean changePassword(String userID, String newPassword);

    /**
     * UpdateDetails method will update the details of user
     * @param user
     * return boolean
     */

    public boolean updateDetails(User user);

    /**
     * User Login method uses SQL commands and verifies the user
     * @param userID
     * @param password
     * @eturn User
     */

    public User login(String userID, String password);

}
