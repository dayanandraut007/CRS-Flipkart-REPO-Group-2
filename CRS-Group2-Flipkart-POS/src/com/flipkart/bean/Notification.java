package com.flipkart.bean;

import com.flipkart.constant.NotificationType;

/**
 * Notification class
 */
public class Notification {
    private int notificationId;
    private int studentId;
    private NotificationType type;
    private String referenceId;

    /**
     * Default constructor
     */
    public Notification() {
    }

    /**
     * Parameterized constructor
     * @param notificationId
     * @param studentId
     * @param type
     * @param referenceId
     */
    public Notification(int notificationId, int studentId, NotificationType type, String referenceId) {
        this.notificationId = notificationId;
        this.studentId = studentId;
        this.type = type;
        this.referenceId = referenceId;
    }

    /**
     * Method to get notification id
     * @return notification id
     */
    public int getNotificationId() {
        return notificationId;
    }

    /**
     * Method to set the notification id
     * @param notificationId
     */
    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    /**
     * Method to get the student id
     * @return student id
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Method to set the student id
     * @param studentId
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Method ot get the type of the notification
     * @return type of the notification
     */
    public NotificationType getType() {
        return type;
    }

    /**
     * Method to set the type of the notification
     * @param type
     */
    public void setType(NotificationType type) {
        this.type = type;
    }

    /**
     * Method to get the reference id
     * @return reference id
     */
    public String getReferenceId() {
        return referenceId;
    }

    /**
     * Method to set reference id
     * @param referenceId
     */
    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
