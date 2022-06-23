package com.flipkart.constant;

public class SQLQueriesConstants2 {

    public static final String ADD_COURSE_QUERY = "INSERT INTO `CRSDatabase`.`course` (`course_code`, `course_name`, `prerequisite`,`instructor_id`, `seats`) VALUES (?,?,?,?,?)";
    public static final String DELETE_COURSE_QUERY = "delete from `CRSDatabase`.`course` where course_code=?";
    public static final String ADD_PROFESSOR_QUERY = "insert into Professor(professor_id,professor_name, department, designation,gender,address) values (?, ?, ?,?,?,?)";
    public static final String VIEW_PROFESSORS_QUERY = "Select * from Professor";
    public static final String PENDING_STUDENTS_QUERY = "Select * from student where is_approved=0";
    public static final String APPROVE_STUDENTS_QUERY = "update student set is_approved=1 where student_id=?";
    public static final String ADD_USER_QUERY = "insert into user(user_id,password,role) values (?,?,?)";
    public static final String LOGIN= "select * from user where user_id=? and password=?";

}
