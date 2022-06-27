package com.flipkart.exception;

/**
 * Exception class for seat not available
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class SeatNotAvailableException extends Exception{

    private String courseCode;
    /**
     * Constructor
     * @param courseCode
     */
    public SeatNotAvailableException(String courseCode)
    {
        this.courseCode = courseCode;
    }


    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return  "Seats are not available in : " + courseCode;
    }


}