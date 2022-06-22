package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.MockData;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AdminImpl implements AdminInterface {

    CourseInterface courseInterface;
    //-------------------HARD CODED------------------------------------
    MockData data = MockData.getInstance();

    //-----------------------------------------------------------------
    public AdminImpl(){
        courseInterface = new CourseImpl();
    }
    @Override
    public boolean deleteCourse(String courseCode) {
        Iterator<Course> itr = data.courses.iterator();
        while(itr.hasNext()){
            if(itr.next().getCourseCode().equals(courseCode)){
                itr.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addCourse(Course course) {
        data.courses.add(course);
        return true;
    }

    @Override
    public List<Student> viewPendingAdmissions() {
        return null;
    }

    @Override
    public void approveStudent() {
        Iterator<Student> itr = data.students.iterator();
        while(itr.hasNext()){
            Student std = itr.next();
            if(!std.isApproved()){
                System.out.println("The name is " + std.getName() + " and branch is " + std.getBranch() );
                Scanner sc = new Scanner(System.in);
                System.out.print("Type A for approve and D for disapprove");
                String status = sc.next();
                if(status.equals("A")){
                    std.setApproved(true);
                    data.users.add(std);
                }
                else if(status.equals("D")){
                    itr.remove();
                }
                else{
                    System.out.println("Invalid");
                }

            }
        }
    }

    @Override
    public void addProfessor(Professor professor) {
        data.professors.add(professor);
        for(Professor prof: data.professors){
            System.out.println(prof.getUserID());
        }

    }

    @Override
    public void assignCourse(String courseCode, String professorId) {

    }

    @Override
    public List<Course> viewCourses() {
        return data.courses;
    }

    @Override
    public List<Professor> viewProfessors() {
        return data.professors;
    }

    @Override
    public void notifyCourseChange() {

    }
}
