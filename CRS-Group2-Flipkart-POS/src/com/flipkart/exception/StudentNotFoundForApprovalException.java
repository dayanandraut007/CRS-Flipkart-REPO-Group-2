
package com.flipkart.exception;


public class StudentNotFoundForApprovalException extends Exception {
    private int studentId;

    public StudentNotFoundForApprovalException(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return this.studentId;
    }

    @Override
    public String getMessage() {
        return "studentId: " + studentId + " not found for approval!" ;
    }
}