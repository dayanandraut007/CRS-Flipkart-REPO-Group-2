package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.constant.Grade;
import com.flipkart.constant.Role;
import com.flipkart.constant.SQLQueriesConstants;
import com.flipkart.constant.SQLQueriesConstants2;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.utils.DBUtils;
import javafx.util.Pair;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * The StudentDaoImpl class implements the StudentDaoInterface
 * To provide the functionality to interact with the database
 *
 * @author
 * JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since June 2022
 */
public class StudentDaoImpl implements StudentDaoInterface {
    private static StudentDaoImpl instance = null;
    private PreparedStatement statement = null;



    private StudentDaoImpl() {
    }

    public static StudentDaoImpl getInstance() {
        if (instance == null) {
            instance = new StudentDaoImpl();
        }
        return instance;
    }

    Connection connection = DBUtils.getConnection();


    /**
     * Method to register student in database
     * @param name: name of student
     * @param userID: user Id of student
     * @param password: password of student
     * @param gender: gender of student
     * @param batch: batch of student
     * @param branch: branch of student
     * @param address: address of student
     * @return student object
     *
     */

    @Override
    public Student register(String name, String userID, String password, String gender, int batch, String branch, String address) {
        Student stud1 = new Student(userID, name, password, Role.STUDENT, Integer.parseInt(userID), branch, batch, false, address, false, false);
        String sql = SQLQueriesConstants.STUDENT_REGISTRATION_QUERY;
        statement = null;
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
//            System.out.println(statement.toString());

            int row = statement.executeUpdate();
            if (row == 0) {
                System.out.println("Couldn't add the course");
            }
            System.out.println("Added successfully");

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    /**
     * Method to do semester registration of the student
     * @param userId
     *
     * @return student
     */
    @Override
    public boolean semesterRegistration(String userId) {

        statement = null;
        try {

            String sql1 = SQLQueriesConstants.SEMESTER_REGISTRATION_UPDATE_QUERY;
            statement = connection.prepareStatement(sql1);
            statement.setString(1, userId);
//            System.out.println(statement.toString());

            int row = statement.executeUpdate();

            if (row == 0) {
                System.out.println("Couldn't Register Student");
                return false;
            }
            System.out.println("Registered Successfully");
            List<String> registeredCourses = viewRegisteredCourses(userId);
            for(String st: registeredCourses){
                String sql = SQLQueriesConstants2.INSERT_IN_GRADE_CARD;
                statement = connection.prepareStatement(sql);
                statement.setString(1,userId);
                statement.setString(2,st);
                statement.executeUpdate();
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method to fetch the details of the student by its ID
     * @param userId
     *
     * @return student
     */
    @Override
    public Student getStudentById(String userId) {
        String sql = SQLQueriesConstants.GET_STUDENT_BY_ID_QUERY;
        statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            ResultSet rs = statement.executeQuery();
            Student st = new Student();
//            System.out.println(rs);
            if (rs.next()) {
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
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    /**
     * Method to check whether admin has approved the student
     * @param studentId
     *
     * @return boolean
     */
    @Override
    public boolean isApproved(String studentId) {
        statement = null;
        try {
            String sql = SQLQueriesConstants.IS_APPROVED_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(studentId));
//            System.out.println(statement.toString());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                if (rs.getInt(1) == 1)
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Method to add course for the student
     * @param userId
     * @param courseCode
     * @param primary
     *
     * @return boolean
     */
    @Override
    public boolean addCourse(String userId, String courseCode, String primary) {

        /*
        check if there are available seats
         */
        statement = null;
        try {
            String sql0 = SQLQueriesConstants2.CHECK_AVAILABLE_SEATS;
            statement = connection.prepareStatement(sql0);
            statement.setString(1, courseCode);
            ResultSet rs = statement.executeQuery();
            int availableSeats = 0;
            if (rs.next()) {
                availableSeats = rs.getInt(1);
            }

            if (availableSeats <= 0) {
                System.out.println("No seats available");
                return false;
            }
            String sql = SQLQueriesConstants2.ADD_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1, userId);
            statement.setString(2, courseCode);

            statement.setBoolean(3, primary.equals("Y"));


//            System.out.println(statement.toString());

            int row = statement.executeUpdate();

            if (row == 0) {
               System.out.println("Couldn't add course");
                return false;
            }
            System.out.println("Course Added Successfully");
            String sql2 = SQLQueriesConstants2.UPDATE_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql2);
            statement.setString(1, courseCode);

//            System.out.println(statement.toString());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Method to drop course of the Student
     * @param userId
     * @param courseCode
     * @return boolean
     */
    @Override
    public boolean dropCourse(String userId, String courseCode) {
        statement = null;
        try {
            String sql = SQLQueriesConstants2.DROP_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);

            statement.setString(1, userId);
            statement.setString(2, courseCode);

//            System.out.println(statement.toString());

            int row = statement.executeUpdate();
//            System.out.println(row);
            if (row == 0) {
                System.out.println("Couldn't drop course");
                return false;
            }
            System.out.println("Dropped Successfully");
            String sql2 = SQLQueriesConstants2.UPDATE_DROP_COURSE_STUDENT_QUERY;
            statement = connection.prepareStatement(sql2);
            statement.setString(1, courseCode);

//            System.out.println(statement.toString());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Method to see the list of the courses registered by the student
     * @param userId
     * @return list of registered courses
     */
    @Override
    public List<String> viewRegisteredCourses(String userId) {
        statement = null;
        List<String> registeredCourses = new ArrayList<>();
        try {
            String sql = SQLQueriesConstants2.VIEW_REGISTERED_COURSES_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
//            System.out.println(statement.toString());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                registeredCourses.add(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registeredCourses;
    }

    /**
     * Method to see list of added courses
     * @param userId
     * @return list of added courses
     */
    @Override
    public List<Pair<String,Boolean>> viewAddedCourses(String userId) {
        statement = null;
        List<Pair<String,Boolean>> registeredCourses = new ArrayList<>();
        try {
            String sql = SQLQueriesConstants2.VIEW_ADDED_COURSES_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
//            System.out.println(statement.toString());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pair<String,Boolean> pr= new Pair(resultSet.getString(2),resultSet.getBoolean(3));
                registeredCourses.add(pr);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registeredCourses;
    }

    /**
     * Method to see list of all the courses
     * @return list of courses
     */
    @Override
    public List<Course> viewAllCourses() {
        statement = null;
        List<Course> courseList = new ArrayList<>();
        try {

            String sql = SQLQueriesConstants.VIEW_COURSE_QUERY;
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Course course = new Course();
                course.setCourseCode(resultSet.getString(1));
                course.setName(resultSet.getString(2));
                course.setInstructor(resultSet.getString(3));
                course.setPrerequisites(resultSet.getString(4));
                course.setSeats(resultSet.getInt(5));
                courseList.add(course);

            }

        } catch (SQLException se) {
            se.printStackTrace();
        }

        return courseList;
    }

    /**
     * Method to approve payment of Student
     * @param userId
     * @return
     * {@link Boolean}
     */
    @Override
    public boolean approvePayment(String userId) {
        // check primary and optional courses requirements
        // make payment and update payment table
        statement = null;
        try {
            String sql1 = SQLQueriesConstants.MAKE_PAYMENT_STUDENT_QUERY;
            statement = connection.prepareStatement(sql1);
            statement.setString(1, userId);
//            System.out.println(statement.toString());

            int row = statement.executeUpdate();

            if (row == 0) {
                System.out.println("Couldn't Make Payment");
                return false;
            }
            System.out.println("Payment Successful");
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Method to see the grade card of the student
     * @param userId
     * @return list of student grade
     */
    @Override
    public List<StudentGrade> viewGradeCard(String userId) {
        statement = null;
        List<StudentGrade> gradeList = new ArrayList<>();
        try {

            String sql = SQLQueriesConstants2.VIEW_GRADE_CARD;
            statement = connection.prepareStatement(sql);
            statement.setString(1,userId);
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

    /**
     * Method to Check registration eligibility of the student
     * @param userId
     * @return  Boolean
     */
    @Override
    public boolean checkRegistrationEligibility(String userId) {
        statement = null;
        try {
            String sql = SQLQueriesConstants.SEMESTER_REGISTRATION_STUDENT_QUERY;
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
//            System.out.println(statement.toString());
            ResultSet rs = statement.executeQuery();
            int primary = 0, optional = 0;

            while (rs.next()) {
                if (rs.getInt(1) == 1)
                    primary++;
                else
                    optional++;
            }
            if (primary == 4 && optional == 2) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * method to make payment for the semester
     * @param userId
     * @param transactionId
     * @param paymentMethod
     * @param amount
     * @return Boolean
     */
    public boolean makePayment(String userId, String transactionId, String paymentMethod, float amount) {
        Payment payment = new Payment(userId, amount, paymentMethod, transactionId);
        String sql = SQLQueriesConstants.PAYMENT_QUERY;
        statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            statement.setString(2, transactionId);
            statement.setString(3, paymentMethod);
            statement.setFloat(4, amount);

            // Print query

            int row = statement.executeUpdate();
            if (row == 0) {
                System.out.println("Couldn't add Payment");
            }
            System.out.println("Payment Added successfully");
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return true;
    }

    /**
     * method to check whether a course has been added or not
     * @param userId
     * @param courseId
     * @return Boolean
     */
    @Override
    public boolean courseNotAdded(String userId,String courseId){
        statement = null;
        try {

            String sql = SQLQueriesConstants.COURSE_ADD_CHECK_QUERY;
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
