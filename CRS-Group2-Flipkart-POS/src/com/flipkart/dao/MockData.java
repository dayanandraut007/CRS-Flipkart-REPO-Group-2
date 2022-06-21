package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockData {

    public  List<User> users;
    public List<Professor> professors;
    public List<Admin> admins;
    public List<Course> courses;
    public List<Student> students;

    // singleton object
    private static MockData mockData = null;

    private MockData(){

        users = new ArrayList<>();
        professors = new ArrayList<>();
        admins = new ArrayList<>();
        students = new ArrayList<>();
        courses = new ArrayList<>();

        User user1 = new User("007", "daya", "pass", Role.PROFESSOR);
        User user2 = new User("008", "kashish", "pass", Role.ADMIN);
        User user3 = new User("009", "deepak", "pass", Role.STUDENT);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Course course1 = new Course("C001","Operating System",true,"daya","NA",10);
        Course course2 = new Course("C002","System Design",true,"daya","NA",9);
        Course course3 = new Course("C003","DSA",true,"XYZ","NA",8);
        Course course4 = new Course("C004","OOP",false,"XYZ","NA",8);
        Course course5 = new Course("C005","JAVA",false,"ABC","NA",7);
        Course course6 = new Course("C006","C++",true,"MNP","NA",8);
        Course course7 = new Course("C007","Python",true,"MNP","NA",10);
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);
        courses.add(course7);

        Student student1 = new Student("009", "deepak", "pass", Role.STUDENT, 9, "CSE", 10, false, "india");
        students.add(student1);

        Professor professor1 = new Professor("007","daya", "pass", Role.PROFESSOR, 7, "CSE", Gender.MALE, "Professor", new Date(),"Nepal");
        professors.add(professor1);
    }

    public static MockData getInstance(){
        if(mockData==null){
            return new MockData();
        }
        return  mockData;
    }


}
