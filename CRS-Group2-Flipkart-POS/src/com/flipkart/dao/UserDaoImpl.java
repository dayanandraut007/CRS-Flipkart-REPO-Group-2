package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstants2;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Implementation for User Dao operations
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class UserDaoImpl implements UserDaoInterface{


    private static UserDaoImpl instance = null;
    private PreparedStatement statement = null;
    private UserDaoImpl(){}

    public static UserDaoImpl getInstance(){
        if(instance == null){
            instance = new UserDaoImpl();
        }
        return instance;
    }

    Connection connection = DBUtils.getConnection();

    /**
     * changePassword method is used to change the password
     * @param userID
     * @param newPassword
     * @return type boolean
     */

    @Override
    public boolean changePassword(String userID, String newPassword) {
        return false;
    }

    /**
     * UpdateDetails method will update the details of user
     * @param user
     * @return {@link Boolean}
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
    public User login(String userID, String password) {
        statement = null;

        try{
            User usr = null;
            String sql = SQLQueriesConstants2.LOGIN;
            statement = connection.prepareStatement(sql);
            statement.setString(1,userID);
            statement.setString(2,password);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                usr = new User();
                usr.setUserID(resultSet.getString(1));

                usr.setRole(Role.valueOf(resultSet.getString(3).toUpperCase()));
            }
            return usr;
        }catch(SQLException se){
            se.printStackTrace();
        }
        return null;
    }
}
