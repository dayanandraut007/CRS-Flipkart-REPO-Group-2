
package com.flipkart.exception;


public class UserAlreadyExistException extends Exception{
    private String userId;
    private String userName;


    public UserAlreadyExistException(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setProfessorId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getMessage() {
        return userName+"with userId: " + userId + " is already in use.";
    }

}