package com.flipkart.dao;

import com.flipkart.bean.User;

/**
 * Interface for implementation of User Dao operations
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

public interface UserDaoInterface {

    /**
     * changePassword method is used to change the password
     * @param userID
     * @param newPassword
     * @return type boolean
     */
    public boolean changePassword(String userID, String newPassword);

    /**
     * UpdateDetails method will update the details of user
     * @param user
     * @return boolean
     */
    public boolean updateDetails(User user);

    /**
     * User Login method uses SQL commands and verifies the user
     * @param userID
     * @param password
     * @return user object
     */
    public User login(String userID, String password);
}
