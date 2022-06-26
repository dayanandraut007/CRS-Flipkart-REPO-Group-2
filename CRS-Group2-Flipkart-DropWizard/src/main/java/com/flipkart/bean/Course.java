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

    /**
     * Default constructor
     */
    public Course()
    {
        this.enrolled = new ArrayList<>();
    }

    /**
     * Parameterized constructor
     * @param courseCode: course code
     * @param name: course name
     * @param isOffered: boolean
     * @param instructor: instructor of the course
     * @param prerequisites: prerequisites for the cours
     * @param seats: number of seats available
     * @param enrolled: boolean
     */
    public Course(String courseCode, String name, boolean isOffered, String instructor, String prerequisites, int seats, List<Student> enrolled) {

        this.courseCode = courseCode;
        this.name = name;
        this.isOffered = isOffered;
        this.instructor = instructor;
        this.prerequisites = prerequisites;
        this.seats = seats;
        this.enrolled = enrolled;
    }

    /**
     * Method to get course code
     * @return course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Method to get enrolled students
     * @return boolean value whether the student is enrolled or not
     */
    public List<Student> getEnrolled() {
        return enrolled;
    }

    /**
     * Method to set enrolled
     * @param enrolled
     */
    public void setEnrolled(List<Student> enrolled) {
        this.enrolled = enrolled;
    }

    /**
     * Method to set course code
     * @param courseCode
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * Method to get name
     * @return name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set course name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to check whether the course is offered or not
     * @return boolean value whether the course is offered or not
     */
    public boolean getIsOffered() {
        return isOffered;
    }

    /**
     * Method to set the course to be offered or not
     * @param isOffered
     */
    public void setIsOffered(boolean isOffered) {
        this.isOffered = isOffered;
    }

    /**
     * Method to get the instructor of the course
     * @return instructor of the course
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * Method to set the instructor of the course
     * @param instructor
     */
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    /**
     * Method to get the pre-requisites required for the course
     * @return pre-requisites for the course
     */
    public String getPrerequisites() {
        return prerequisites;
    }

    /**
     * Method to set the pre-requisites required for the course
     * @param prerequisites
     */
    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    /**
     * Method to get the number of seats available for the course
     * @return number of seats available for the course
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Method to set the number of the seats for the course
     * @param seats
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }
}
