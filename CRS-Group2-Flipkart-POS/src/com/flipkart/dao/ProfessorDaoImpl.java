package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Grade;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessorDaoImpl implements ProfessorDaoInterface{


    private static ProfessorDaoImpl instance = null;
    private PreparedStatement statement = null;
    private ProfessorDaoImpl(){}

    public static ProfessorDaoImpl getInstance()
    {
        if(instance == null)
        {
            instance = new ProfessorDaoImpl();
        }
        return instance;
    }

    Connection connection = DBUtils.getConnection();

    @Override
    public List<EnrolledStudent> viewAssignedStudents(String professorId) {
        statement = null;
        List<EnrolledStudent> enrolledStudents =  new ArrayList<>();
        try{
            String sql = SQLQueriesConstants.VIEW_ENROLLED_STUDENTS;
            statement = connection.prepareStatement(sql);
            statement.setString(1, professorId);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                EnrolledStudent enrollstud =new EnrolledStudent();

                enrollstud.setCourseCode(resultSet.getString(1));
                enrollstud.setCourseName(resultSet.getString(2));
                enrollstud.setStudentId(resultSet.getString(3));

                enrolledStudents.add(enrollstud);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return enrolledStudents;


    }

    @Override
    public boolean addGrade(String userId, String courseId, String studentId, String grade) {
        statement = null;

        try {

            String sql1 = SQLQueriesConstants.CHECK_VALID_COURSES_QUERY_FOR_ADD_GRADE;
            statement = connection.prepareStatement(sql1);
            statement.setString(1, courseId);
            statement.setString(2, studentId);

            ResultSet rs2 = statement.executeQuery();

            if( !rs2.next() )
            {
                return false;
            }


            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {

                String sql2 = SQLQueriesConstants.ADD_GRADE_QUERY;
                statement = connection.prepareStatement(sql2);

                statement.setString(2, studentId);
                statement.setString(3, courseId);
                statement.setString(1, grade);
                System.out.println(statement.toString());

                int row = statement.executeUpdate();

                if (row == 0) {
                    System.out.println("Couldn't add the grade");
                    return false;
                }


                System.out.println("GRADE ADDED SUCCESSFULLY!");
            }


        }catch(SQLException se) {

            //se.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Course> viewTeachingCourses(String professorId) {
        statement = null;
        List<Course> teachingCourses =  new ArrayList<>();
        try{
            String sql = SQLQueriesConstants.VIEW_TEACHING_COURSES_PROFESSOR_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, professorId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Course course = new Course();
                course.setCourseCode(resultSet.getString(1));
                course.setName(resultSet.getString(2));
//                course.setCourseName(resultSet.getString(2));
//               course.setInstructorId(resultSet.getString(3));

                teachingCourses.add(course);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return teachingCourses;

    }

    @Override
    public Professor getProfessorById(String professorId) {
        //return ProfessorDaoInterface.getProfessorById(professorId);
        String sql = SQLQueriesConstants.GET_PROFESSOR_BY_ID_QUERY;
        statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, professorId);
            ResultSet rs = statement.executeQuery();
            Professor pf = new Professor();
//            System.out.println(rs);
            if (rs.next()) {
                pf.setUserID(rs.getString(1));
                pf.setName(rs.getString(2));
                pf.setDepartment(rs.getString(3));
                pf.setDesignation(rs.getString(4));
                pf.setGender(Gender.valueOf(rs.getString(5)));
                pf.setDateOfJoining(rs.getDate(6));
                pf.setAddress(rs.getString(7));
            }
            return pf;
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;

    }
    @Override
    public boolean courseAssignedToProfessor(String userId, String courseId){
        statement = null;
        try {

            String sql = SQLQueriesConstants.CHECK_PROFESSOR_COURSE_ASSIGNED;
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            statement.setString(2, courseId);

            ResultSet rs = statement.executeQuery();
            return rs.next();

        }catch(SQLException se) {
            se.printStackTrace();
        }
        return true;
    }
}
