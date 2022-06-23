package com.flipkart.constant;

public class SQLQueriesConstants2 {

    public static final String ADD_COURSE_QUERY = "INSERT INTO `CRSDatabase`.`course` (`course_code`, `course_name`, `prerequisite`,`instructor_id`, `seats`) VALUES (?,?,?,?,?)";
    public static final String DELETE_COURSE_QUERY = "delete from `CRSDatabase`.`course` where course_code=?";
    public static final String ADD_PROFESSOR_QUERY = "insert into Professor(professor_id,professor_name, department, designation,gender,address) values (?, ?, ?,?,?,?)";
    public static final String VIEW_PROFESSORS_QUERY = "Select * from Professor";

}
