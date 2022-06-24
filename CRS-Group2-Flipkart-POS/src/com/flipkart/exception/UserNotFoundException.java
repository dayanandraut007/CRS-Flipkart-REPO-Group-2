package com.flipkart.exception;

/**
 * Exception class for user not found
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class UserNotFoundException extends Exception {

        private String userId;
        private String userName;

    /**
     *
     * @param userId
     * @param userName
     */

        public UserNotFoundException(String userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

    /**
     * Method to return exception message
     * @return {@link String}
     */
    @Override
        public String getMessage() {
            return userName+" with userId: " + userId + " not found.";
        }

    }



