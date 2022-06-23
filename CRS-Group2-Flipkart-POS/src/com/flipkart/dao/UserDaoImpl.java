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
    @Override
    public boolean changePassword(String userID, String newPassword) {
        return false;
    }

    @Override
    public boolean updateDetails(User user) {
        return false;
    }

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
