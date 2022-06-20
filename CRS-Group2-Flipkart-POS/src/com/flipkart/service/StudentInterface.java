package com.flipkart.service;

public interface StudentInterface {
    public int register(String name,String userID,String password,String gender,int batch,
                        String branch,String address,String country);

    public int getStudentId(String userId);

    public boolean isApproved(int studentId);
}
