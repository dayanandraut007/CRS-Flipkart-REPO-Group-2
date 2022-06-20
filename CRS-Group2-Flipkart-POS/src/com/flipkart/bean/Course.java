package com.flipkart.bean;

public class Course {

    private String courseCode;
    private String name;
    private boolean isOffered;
    private String instructor;
    private String prerequisites;
    private int seats = 10;

    public Course()
    {

    }


    public Course(String courseCode, String name, boolean isOffered, String instructor, String prerequisites, int seats) {
        this.courseCode = courseCode;
        this.name = name;
        this.isOffered = isOffered;
        this.instructor = instructor;
        this.prerequisites = prerequisites;
        this.seats = seats;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsOffered() {
        return isOffered;
    }

    public void setIsOffered(boolean isOffered) {
        this.isOffered = isOffered;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
