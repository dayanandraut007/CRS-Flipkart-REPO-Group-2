package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Role;
import com.flipkart.dao.MockData;
import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.StudentDaoInterface;

import java.util.List;

public class StudentImpl implements StudentInterface {


    CourseInterface courseInterface;
    AdminInterface adminInterface;
    //-------------------HARD CODED------------------------------------
    MockData data = MockData.getInstance();
    StudentDaoInterface studentDaoInterface = StudentDaoImpl.getInstance();

    //-----------------------------------------------------------------
    public StudentImpl(){
        courseInterface = new CourseImpl();
        adminInterface = new AdminImpl();
    }



    @Override
    public Student register(String name, String userID, String password, String gender, int batch, String branch, String address) {
        Student stud1 = studentDaoInterface.register(name,userID,password,null,batch,branch,address);
        return stud1;
    }

    @Override
    public boolean semesterRegistration(String userId) {
        for(Student std: data.students){
            if(std.getUserID().equals(userId)){
                if(std.getCourses().size() < 6){
                    return false;
                }
                else{
                    std.setHasRegistered(true);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentDaoInterface.getStudentById(studentId);
    }

    @Override
    public boolean isApproved(String studentId) {
        return studentDaoInterface.isApproved(studentId);
    }

    @Override
    public boolean addCourse(String userId ,String courseCode,String primary) {
        return studentDaoInterface.addCourse(userId,courseCode,primary);

    }

    @Override
    public boolean dropCourse(String userId, String courseCode) {

        return studentDaoInterface.dropCourse(userId,courseCode);
    }

    @Override
    public List<String> viewRegisteredCourses(String userId) {
        return studentDaoInterface.viewRegisteredCourses(userId);
    }
    @Override
    public List<String> viewAddedCourses(String userId) {
        return studentDaoInterface.viewAddedCourses(userId);
    }

    @Override
    public List<Course> viewAllCourses() {
        return studentDaoInterface.viewAllCourses();
    }

    @Override
    public boolean makePayment(int studentId) {
        //
        return false;
    }
}
