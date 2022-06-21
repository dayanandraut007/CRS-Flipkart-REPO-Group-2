package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Role;
import com.flipkart.dao.MockData;

import java.util.List;

public class StudentImpl implements StudentInterface {


    CourseInterface courseInterface;
    AdminInterface adminInterface;
    //-------------------HARD CODED------------------------------------
    MockData data = MockData.getInstance();

    //-----------------------------------------------------------------
    public StudentImpl(){
        courseInterface = new CourseImpl();
        adminInterface = new AdminImpl();
    }



    @Override
    public Student register(String name, String userID, String password, String gender, int batch, String branch, String address) {
        Student stud1=new Student(userID,name,password,Role.STUDENT,Integer.parseInt(userID),branch,batch,false,address);

        data.students.add(stud1);
        return stud1;
    }

    @Override
    public Student getStudentById(int studentId) {
        for(Student std: data.students){
            if(std.getStudentID() == studentId){
                return std;
            }
        }
        return null;
    }

    @Override
    public boolean isApproved(int studentId) {
        for(Student student: data.students){
            if(student.getStudentID() == studentId){
                return student.isApproved();
            }
        }
        return false;
    }

    @Override
    public boolean addCourse(String userId ,String courseCode) {
        for(Student student: data.students){
            if(student.getUserID().equals(userId)){
                List<String> courses = student.getCourses();
                courses.add(courseCode);
                System.out.println(courses);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean dropCourse(String userId, String courseCode) {

        for(Student student: data.students){
            if(student.getUserID().equals(userId)){
                List<String> courses = student.getCourses();
                if(courses.contains(courseCode)){
                    courses.remove(courseCode);
                    System.out.println(courses);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<String> viewRegisteredCourses(String userId) {
        List<Student> listOfStudent = data.students;
        List<String> regCourses = null;
        for(Student st: listOfStudent) {
            if(st.getUserID().equals(userId)) {
                regCourses = st.getCourses();
            }
        }
        return  regCourses;
    }

    @Override
    public List<Course> viewAllCourses() {
        return courseInterface.viewAllCourses();
    }

    @Override
    public float calculateFees(int studentId) {
        return 0;
    }
}
