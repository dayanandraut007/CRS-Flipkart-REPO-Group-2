package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.constant.Grade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockData {

    public  List<User> users;
    public List<Professor> professors;
    public List<Admin> admins;
    public List<Course> courses;
    public List<Student> students;

    public List<Student> enrolledStudent;

    public List<Student> enrolledStudent2;

    public List<StudentGrade> grade;

    // singleton object
    private static MockData mockData = null;

    private MockData(){

        users = new ArrayList<>();
        professors = new ArrayList<>();
        admins = new ArrayList<>();
        students = new ArrayList<>();
        courses = new ArrayList<>();
        grade = new ArrayList<>();



        User user1 = new User("007", "daya", "pass", Role.PROFESSOR);
        User user2 = new User("008", "kashish", "pass", Role.ADMIN);
        User user3 = new User("009", "deepak", "pass", Role.STUDENT);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        Student student1 = new Student("009", "deepak", "pass", Role.STUDENT, 9, "CSE", 10, false, "india",false,false);
        students.add(student1);
        Student student2 = new Student("010", "harshita", "pass", Role.STUDENT, 10, "CSE", 10, false, "india",false,false);
        students.add(student2);
        Student student3 = new Student("011", "kashish", "pass", Role.STUDENT, 11, "CSE", 10, false, "india",false,false);
        students.add(student3);

//        StudentGrade studentGrade = new StudentGrade("C001",Grade.A,9);
//        StudentGrade studentGrade2 = new StudentGrade("C002",Grade.B,10);
//        grade.add(studentGrade);
//        grade.add(studentGrade2);


        Professor professor1 = new Professor("007","daya", "pass", Role.PROFESSOR, 7, "CSE", Gender.MALE, "Professor", new Date(),"Nepal");
        professors.add(professor1);

        enrolledStudent = new ArrayList<>();

        enrolledStudent2 = new ArrayList<>();





        Course course1 = new Course("C001","Operating System",true,"daya","NA",10,new ArrayList<>());
        Course course2 = new Course("C002","System Design",true,"daya","NA",9,new ArrayList<>());
        Course course3 = new Course("C003","DSA",true,"XYZ","NA",8,new ArrayList<>());
        Course course4 = new Course("C004","OOP",false,"XYZ","NA",8,new ArrayList<>());
        Course course5 = new Course("C005","JAVA",false,"ABC","NA",7,new ArrayList<>());
        Course course6 = new Course("C006","C++",true,"MNP","NA",8,new ArrayList<>());
        Course course7 = new Course("C007","Python",true,"MNP","NA",10,new ArrayList<>());
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);
        courses.add(course7);


    }

    public static MockData getInstance(){
        if(mockData==null){
            mockData =  new MockData();
        }
        return  mockData;
    }


}
