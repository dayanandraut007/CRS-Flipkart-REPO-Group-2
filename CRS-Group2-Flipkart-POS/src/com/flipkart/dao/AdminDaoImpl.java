package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.Grade;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.constant.SQLQueriesConstants2;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminDaoImpl implements  AdminDaoInterface{


    private static AdminDaoImpl instance = null;
    private PreparedStatement statement = null;
    private PreparedStatement statement1 = null;
    private AdminDaoImpl(){}

    public static AdminDaoImpl getInstance()
    {
        if(instance == null)
        {
            instance = new AdminDaoImpl();
        }
        return instance;
    }

    Connection connection = DBUtils.getConnection();


    @Override
    public boolean deleteCourse(String courseCode) {
        statement = null;
        try {

            String sql = SQLQueriesConstants2.DELETE_COURSE_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1, courseCode);

            // Print query
            System.out.println(statement.toString());

            int row = statement.executeUpdate();
            if(row == 0) {
                System.out.println("Couldn't delete the course");
                return false;
            }
            System.out.println("Deleted successfully");

        }catch(SQLException se) {

            se.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean addCourse(Course course) {
        statement = null;
        try {

            String sql = SQLQueriesConstants2.ADD_COURSE_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1, course.getCourseCode());
            statement.setString(2, course.getName());
            statement.setString(3, course.getPrerequisites());
            statement.setString(4,course.getInstructor());

            statement.setInt(5, course.getSeats());

            // Print query
            System.out.println(statement.toString());

            int row = statement.executeUpdate();
            if(row == 0) {
                System.out.println("Couldn't add the course");
                return false;
            }
            System.out.println("Added successfully");

        }catch(SQLException se) {

            se.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Student> viewPendingAdmissions() {
        return null;
    }

    public void addToUser(String id,String pass,String role){
        statement = null;
        try {

            String sql = SQLQueriesConstants2.ADD_USER_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1, id);
            statement.setString(2, pass);
            statement.setString(3, role);

            // Print query
            System.out.println(statement.toString());

            int row = statement.executeUpdate();
            if(row == 0) {
                System.out.println("Couldn't add the user");
            }
            //System.out.println("Added successfully");

        }catch(SQLException se) {

            se.printStackTrace();
        }
    }

    @Override
    public void approveStudent() {
        statement = null;
        try{
            String sql = SQLQueriesConstants2.PENDING_STUDENTS_QUERY;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String studentId = resultSet.getString(1);
                String name = resultSet.getString(2);
                String branch = resultSet.getString(3);
                System.out.println("The name of Student is: " + name + " and branch is " + branch);
                System.out.println("Type A for approve and D for Disapprove: ");
                Scanner sc = new Scanner(System.in);
                String status = sc.next();
                if(status.equals("A")){
                    String sql2 = SQLQueriesConstants2.APPROVE_STUDENTS_QUERY;
                    statement1 = connection.prepareStatement(sql2);
                    statement1.setString(1,studentId);
                    int row = statement1.executeUpdate();
                    if(row == 0){
                        System.out.println("Cannot Approve");
                    }else{
                        addToUser(studentId,"pass","student");
                        System.out.println("Approved Successfully");
                    }

                }else if(status.equals("D")){

                }else{
                    System.out.println("Wrong Choice");
                }
            }

        }catch(SQLException se){
            se.printStackTrace();
        }

    }

    @Override
    public void addProfessor(Professor professor) {
        statement = null;
        try {

            String sql = SQLQueriesConstants2.ADD_PROFESSOR_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1, professor.getUserID());
            statement.setString(2, professor.getName());
            statement.setString(3, professor.getDepartment());
            statement.setString(4, professor.getDesignation());
            statement.setString(5, professor.getGender().toString());
            statement.setString(6, professor.getAddress());

            // Print query
            System.out.println(statement.toString());

            int row = statement.executeUpdate();
            if(row == 0) {
                System.out.println("Couldn't add the professor");
            }else {
                System.out.println("Added successfully");
                addToUser(professor.getUserID(),"pass","professor");
            }

        }catch(SQLException se) {

            se.printStackTrace();
        }

    }

    @Override
    public void assignCourse(String courseCode, String professorId) {

    }

    @Override
    public List<Course> viewCourses() {
        statement = null;
        List<Course> courseList = new ArrayList<>();
        try {

            String sql = SQLQueriesConstants.VIEW_COURSE_QUERY;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Course course = new Course();
                course.setCourseCode(resultSet.getString(1));
                course.setName(resultSet.getString(2));
//                course.setCourseName(resultSet.getString(2));
//                course.setInstructorId(resultSet.getString(3));
                course.setSeats(resultSet.getInt(5));
                courseList.add(course);

            }

        }catch(SQLException se) {
            se.printStackTrace();
        }

        return courseList;
    }

    @Override
    public List<Professor> viewProfessors() {
        statement = null;
        List<Professor> professorList = new ArrayList<>();
        try {

            String sql = SQLQueriesConstants2.VIEW_PROFESSORS_QUERY;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {

                Professor professor = new Professor();
                professor.setUserID(resultSet.getString(1));
                professor.setName(resultSet.getString(2));
//                course.setCourseName(resultSet.getString(2));
//                course.setInstructorId(resultSet.getString(3));
                professor.setDepartment(resultSet.getString(3));
                professorList.add(professor);

            }

        }catch(SQLException se) {
            se.printStackTrace();
        }

        return professorList;
    }

    @Override
    public List<StudentGrade> generateScoreCard(String studentId) {
        statement = null;
        List<StudentGrade> gradeList = new ArrayList<>();
        try {

            String sql = SQLQueriesConstants2.VIEW_GRADE_CARD;
            statement = connection.prepareStatement(sql);
            statement.setString(1,studentId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                StudentGrade grade = new StudentGrade();
                if(resultSet.getString(3) == null){
                    grade.setGrade(Grade.NA);
                }
                else{
                    grade.setGrade(Grade.valueOf(resultSet.getString(3)));
                }
                grade.setStudentID(resultSet.getString(1));
                grade.setCourseCode(resultSet.getString(2));
                gradeList.add(grade);

            }

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return gradeList;
    }

    @Override
    public void notifyCourseChange() {

    }

    public boolean findCourse(String courseCode)
    {
        statement = null;
        try {

            String sql = SQLQueriesConstants.FIND_COURSE_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, courseCode);

            ResultSet rs = statement.executeQuery();
            return rs.next();

        }catch(SQLException se) {
            se.printStackTrace();
        }
        return true;
    }
    public boolean findUser(String userId)
    {
        statement = null;
        try {

            String sql = SQLQueriesConstants.FIND_USER_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);

            ResultSet row = statement.executeQuery();

            return row.next();

        }catch(SQLException se) {
            se.printStackTrace();
        }
        return true;
    }
}
