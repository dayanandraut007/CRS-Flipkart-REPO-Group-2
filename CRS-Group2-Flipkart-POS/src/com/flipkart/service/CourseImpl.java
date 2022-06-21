package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.User;
import com.flipkart.constant.Role;

import java.util.ArrayList;
import java.util.List;

public class CourseImpl implements  CourseInterface{

    //------------Hardcoded-------------------

    List<Course> courses;

    public CourseImpl(){
        courses = new ArrayList<Course>();
        Course course1 = new Course("C001","Operating System",true,"ABC","NA",10);
        Course course2 = new Course("C002","System Design",true,"ABC","NA",9);
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
    }


    //----------------------------------------

    @Override
    public Course getCourseById(String courseCode) {

        for(Course csr:courses){
            if(csr.getCourseCode().equals(courseCode) ) return csr;
        }

        return null;
    }

    @Override
    public List<Course> viewAllCourses() {
        return courses;
    }
}
