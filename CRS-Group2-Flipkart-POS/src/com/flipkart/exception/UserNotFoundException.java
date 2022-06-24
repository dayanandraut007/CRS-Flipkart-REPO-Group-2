package com.flipkart.exception;

public class UserNotFoundException extends Exception {

        private String userId;
        private String userName;

        public UserNotFoundException(String userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        @Override
        public String getMessage() {
            return userName+" with userId: " + userId + " not found.";
        }

    }



