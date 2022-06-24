package com.flipkart.exception;

/**
 * Exception class for professor not added
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class ProfessorNotAddedException extends Exception{
    private String professorId;

    /**
     *
     * @param professorId
     */
    public ProfessorNotAddedException(String professorId) {
        this.professorId = professorId;
    }

    /**
     * Getter function for professorId
     * @return
     */
    public String getUserId() {
        return this.professorId;
    }


    /**
     * Message returned when exception is thrown
     */
    @Override
    public String getMessage() {
        return "professorId: " + professorId + " not added!";
    }
}