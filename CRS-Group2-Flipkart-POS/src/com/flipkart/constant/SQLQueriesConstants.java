package com.flipkart.constant;

public class SQLQueriesConstants {
    public static final String VIEW_COURSE_QUERY = "SELECT * FROM course";
    public static final String ADD_COURSE_QUERY = "INSERT INTO `CRSDatabase`.`course` (`course_code`, `course_name`, `prerequisite`, `seats`) VALUES (?,?,?,?)";

}
