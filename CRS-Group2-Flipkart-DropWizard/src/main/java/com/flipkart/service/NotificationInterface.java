package com.flipkart.service;

import com.flipkart.constant.ModeOfPayment;
import com.flipkart.constant.NotificationType;

import java.util.UUID;


/**
 * NotificationInterfcae is used to implement the Notification Service Operations
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public interface NotificationInterface {

    /**
     * sendNotification method is used to send notification to the student informing the payment status
     * @param type
     * @param studentId
     * @param modeOfPayment
     * @param amount
     * @param referenceId
     * return int
     */
    public int sendNotification(NotificationType type, int studentId, ModeOfPayment modeOfPayment, double amount,String referenceId);

    /**
     * getReferenceId used to get the reference ID of the payment
     * @param notificationId
     * return UUID
     */

    public UUID getReferenceId(int notificationId);

}
