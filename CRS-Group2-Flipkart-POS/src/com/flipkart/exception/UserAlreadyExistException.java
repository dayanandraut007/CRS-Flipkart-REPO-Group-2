
package com.flipkart.exception;
/**
 * Exception class for user already exist
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */

public class UserAlreadyExistException extends Exception{

    private String userId;
    private String userName;

    /**
     *
     * @param userId
     * @param userName
     */

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

    /**
     * Method to return message for user already exists
     * @return {@link String}
     */
    @Override
    public String getMessage() {
        return userName+"with userId: " + userId + " is already in use.";
    }

}