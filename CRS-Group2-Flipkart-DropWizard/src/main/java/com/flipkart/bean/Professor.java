package com.flipkart.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

import java.util.Date;

/**
 * Professor class
 */
public class Professor extends User{


    private String department;
    private String designation;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
    private Date dateOfJoining;
    private Gender gender;

    /**
     * Method to get the gender of the professor
     * @return gender of the professor
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Method to set the gender of the professor
     * @param gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Method to get the address of the professor
     * @return address of the professor
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method to set the address of the professor
     * @param address
     */

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;

    /**
     * Default constructor
     */
    public Professor(){

    }

    /**
     * Parameterized constructor
     * @param userID
     * @param name
     * @param password
     * @param role
     * @param department
     * @param gender
     * @param designation
     * @param dateOfJoining
     * @param address
     */
    public Professor(String userID, String name, String password, Role role,String department,Gender gender,String designation,Date dateOfJoining,String address) {
        super(userID, name, password, role);
        this.department = department;
        this.designation = designation;
        this.dateOfJoining = dateOfJoining;
        this.gender = gender;
        this.address = address;
    }

    /**
     * Method to get the department of the professor
     * @return department of the professor
     */

    public String getDepartment() {
        return department;
    }

    /**
     * Method to set the department of the professor
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Method to get the designation of the professor
     * @return designation of the professor
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Method to set the designation of the professor
     * @param designation
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * Method to get the Date of Joining of the professor
     * @return the Date of Joining of the professor
     */
    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    /**
     * method to set the Date of Joining
     * @param dateOfJoining
     */
    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }


}
