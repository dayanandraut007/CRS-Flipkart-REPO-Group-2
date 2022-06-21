package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.dao.MockData;

import java.util.Iterator;
import java.util.List;

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
    public void approveStudent(int studentId) {

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
        return null;
    }

    @Override
    public void notifyCourseChange() {

    }
}
