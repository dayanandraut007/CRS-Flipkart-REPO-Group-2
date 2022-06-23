package com.flipkart.dao;

import com.flipkart.bean.Notification;
import com.flipkart.bean.Payment;
import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class NotificationDaoImpl implements NotificationDaoInterface{

    private static NotificationDaoImpl instance = null;
    private PreparedStatement statement = null;
    private NotificationDaoImpl(){}

    public static NotificationDaoImpl getInstance()
    {
        if(instance == null)
        {
            instance = new NotificationDaoImpl();
        }
        return instance;
    }

    Connection connection = DBUtils.getConnection();

    @Override
    public boolean sendNotification(String studentId, String notificationMessage) {
        Notification notification = new Notification();
        String sql = SQLQueriesConstants.NOTIFICATION_QUERY;
        statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, studentId);
            statement.setString(2, notificationMessage);

            // Print query
            System.out.println(statement.toString());

            int row = statement.executeUpdate();
            if(row == 0) {
                System.out.println("Couldn't add Notification");
                return false;
            }
            System.out.println("Notification Added successfully");
            return true;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return false;
    }

    @Override
    public UUID getReferenceId(int notificationId) {
        return null;
    }
}
