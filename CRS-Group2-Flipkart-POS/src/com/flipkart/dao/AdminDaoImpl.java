package com.flipkart.dao;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements  AdminDaoInterface{


    private static AdminDaoImpl instance = null;
    private PreparedStatement statement = null;
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
        return false;
    }

    @Override
    public boolean addCourse(Course course) {
        statement = null;
        try {

            String sql = SQLQueriesConstants.ADD_COURSE_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1, course.getCourseCode());
            statement.setString(2, course.getName());
            statement.setString(3, course.getPrerequisites());

            statement.setInt(4, course.getSeats());

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

    @Override
    public void approveStudent() {

    }

    @Override
    public void addProfessor(Professor professor) {

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
        return null;
    }

    @Override
    public void notifyCourseChange() {

    }
}
