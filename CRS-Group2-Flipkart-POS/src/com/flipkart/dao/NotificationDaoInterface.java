package com.flipkart.dao;

import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;

import java.util.UUID;

/**
 * NotificationDaoInterfcae is used to implement the Notification Dao Operations
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

public interface NotificationDaoInterface {

    /**
     * sendNotification method is used to send the notification to user
     * @param studentId
     * @param notificationMessage
     * return boolean
     */
    public boolean sendNotification(String studentId, String notificationMessage);


    /**
     * getReferenceId used to get the reference ID of the notification
     * @param notificationId
     * return UUID
     */
    public UUID getReferenceId(int notificationId);
}
