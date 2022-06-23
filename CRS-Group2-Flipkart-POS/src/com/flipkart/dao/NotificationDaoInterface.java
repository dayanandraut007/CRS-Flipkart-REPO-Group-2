package com.flipkart.dao;

import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;

import java.util.UUID;

public interface NotificationDaoInterface {
    public boolean sendNotification(String studentId, String notificationMessage);

    public UUID getReferenceId(int notificationId);
}
