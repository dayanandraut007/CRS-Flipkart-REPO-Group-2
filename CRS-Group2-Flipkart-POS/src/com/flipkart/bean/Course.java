package com.flipkart.bean;
//package com.flipkart.bean.Student;


import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseCode;
    private String name;
    private boolean isOffered;
    private String instructor;
    private String prerequisites;
    private int seats = 10;

    private List<Student> enrolled;

    public Course()
    {
        this.enrolled = new ArrayList<>();
    }


    public Course(String courseCode, String name, boolean isOffered, String instructor, String prerequisites, int seats, List<Student> enrolled) {

        this.courseCode = courseCode;
        this.name = name;
        this.isOffered = isOffered;
        this.instructor = instructor;
        this.prerequisites = prerequisites;
        this.seats = seats;
        this.enrolled = enrolled;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public List<Student> getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(List<Student> enrolled) {
        this.enrolled = enrolled;
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
