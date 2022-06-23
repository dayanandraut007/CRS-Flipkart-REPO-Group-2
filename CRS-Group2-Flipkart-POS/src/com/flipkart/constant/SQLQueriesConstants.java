package com.flipkart.constant;

public class SQLQueriesConstants {
    public static final String VIEW_COURSE_QUERY = "SELECT * FROM course";
    public static final String ADD_COURSE_QUERY = "INSERT INTO `CRSDatabase`.`course` (`course_code`, `course_name`, `prerequisite`, `seats`) VALUES (?,?,?,?)";

    public static final String STUDENT_REGISTRATION_QUERY = "INSERT INTO `CRSDatabase`.`student` (`student_id`, `student_name`, `branch`, `batch`, `address`, `is_approved`, `has_registered`, `done_payment`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String GET_STUDENT_BY_ID_QUERY = "SELECT * FROM `CRSDatabase`.`student` WHERE `student_id` = ?";
}
