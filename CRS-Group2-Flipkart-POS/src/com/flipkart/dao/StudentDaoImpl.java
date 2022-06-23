package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDaoInterface{
    private static StudentDaoImpl instance = null;
    private PreparedStatement statement = null;
    private StudentDaoImpl(){}

    public static StudentDaoImpl getInstance()
    {
        if(instance == null)
        {
            instance = new StudentDaoImpl();
        }
        return instance;
    }

    Connection connection = DBUtils.getConnection();

    @Override
    public Student register(String name, String userID, String password, String gender, int batch, String branch, String address) {
        Student stud1=new Student(userID,name,password,Role.STUDENT,Integer.parseInt(userID),branch,batch,false,address,false,false);
        String sql = SQLQueriesConstants.STUDENT_REGISTRATION_QUERY;
        statement =null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userID);
            statement.setString(2, name);
            statement.setString(3, branch);
            statement.setInt(4, batch);
            statement.setString(5, address);
            statement.setBoolean(6, false);
            statement.setBoolean(7, false);
            statement.setBoolean(8, false);


            // Print query
            System.out.println(statement.toString());

            int row = statement.executeUpdate();
            if(row == 0) {
                System.out.println("Couldn't add the course");
            }
            System.out.println("Added successfully");

        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean semesterRegistration(String userId) {
        statement = null;
        try{
            String sql = SQLQueriesConstants.SEMESTER_REGISTRATION_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1,userId);
            System.out.println(statement.toString());
            ResultSet rs = statement.executeQuery();
            if(rs.next()){

                if(rs.getInt(1) < 6){
                    System.out.println("Couldn't Register Student");
                    return false;
                }
                else{
                    String sql1 = SQLQueriesConstants.SEMESTER_REGISTRATION_UPDATE_QUERY;
                    statement = connection.prepareStatement(sql1);
                    statement.setString(1,userId);
                    System.out.println(statement.toString());

                    int row = statement.executeUpdate();

                    if(row == 0)
                    {
                        System.out.println("Couldn't Register Student");
                        return false;
                    }
                    System.out.println("Registered Successfully");
                    return true;
                }
            }
        }
        catch ( SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student getStudentById(String userId) {
        String sql = SQLQueriesConstants.GET_STUDENT_BY_ID_QUERY;
        statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();
            Student st = new Student();
            System.out.println(rs);
            if(rs.next())
            {
                st.setStudentID(Integer.parseInt(rs.getString(1)));
                st.setName(rs.getString(2));
                st.setBranch(rs.getString(3));
                st.setBatch(rs.getInt(4));
                st.setAddress(rs.getString(5));
                st.setApproved(rs.getBoolean(6));
                st.setHasRegistered(rs.getBoolean(7));
                st.setDonePayment(rs.getBoolean(8));
            }
            return st;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isApproved(int studentId) {
        statement = null;
        try{
            String sql = SQLQueriesConstants.IS_APPROVED_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1,String.valueOf(studentId));
            System.out.println(statement.toString());
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                if( rs.getInt(1) == 1)
                    return true;
            }
        }
        catch ( SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addCourse(String userId, String courseCode) {
        statement = null;
        try{
            String sql = SQLQueriesConstants.ADD_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1,userId);
            statement.setString(2,courseCode);

            System.out.println(statement.toString());

            int row = statement.executeUpdate();

            if(row == 0)
            {
                System.out.println("Couldn't add course");
                return false;
            }
            System.out.println("Course Added Successfully");
        }
        catch ( SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean dropCourse(String userId, String courseCode) {
        statement = null;
        try{
            String sql = SQLQueriesConstants.DROP_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1,userId);
            statement.setString(2,courseCode);

            System.out.println(statement.toString());

            int row = statement.executeUpdate();
            System.out.println(row);
            if(row == 0)
            {
                System.out.println("Couldn't drop course");
                return false;
            }
            System.out.println("Dropped Successfully");
        }
        catch ( SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<String> viewRegisteredCourses(String userId) {
        statement = null;
        List<String> registeredCourses =  new ArrayList<>();
        try{
            String sql = SQLQueriesConstants.VIEW_REGISTERED_COURSES_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1,userId);
            System.out.println(statement.toString());
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                registeredCourses.add(resultSet.getString(2));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return registeredCourses;
    }

    @Override
    public List<Course> viewAllCourses() {
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
                course.setInstructor(resultSet.getString(3));
                course.setPrerequisites(resultSet.getString(4));
                course.setSeats(resultSet.getInt(5));
                courseList.add(course);

            }

        }catch(SQLException se) {
            se.printStackTrace();
        }

        return courseList;
    }

    @Override
    public boolean makePayment(int studentId) {
        return false;
    }
}
