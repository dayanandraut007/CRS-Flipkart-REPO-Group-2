package com.flipkart.constant;

public class SQLQueriesConstants {
    public static final String VIEW_COURSE_QUERY = "SELECT * FROM course";
    public static final String ADD_COURSE_QUERY = "INSERT INTO `CRSDatabase`.`course` (`course_code`, `course_name`, `prerequisite`, `seats`) VALUES (?,?,?,?)";

    public static final String ADD_COURSE_STUDENT_QUERY = "INSERT INTO `CRSDatabase`.`student_enrolled_course` (`student_id`, `course_id`) VALUES (?,?);";

    public static final String DROP_COURSE_STUDENT_QUERY = "DELETE FROM `CRSDatabase`.`student_enrolled_course` WHERE (`student_id` = ?) and (`course_id` = ?);";

    public static final String VIEW_REGISTERED_COURSES_STUDENT_QUERY = "SELECT * FROM CRSDatabase.student_enrolled_course where student_id = ?;";

    public static final String IS_APPROVED_STUDENT_QUERY = "SELECT is_approved FROM CRSDatabase.student where student_id = ?;";

    public static final String SEMESTER_REGISTRATION_STUDENT_QUERY = "SELECT count(*) FROM CRSDatabase.student_enrolled_course where student_id = ?;";

    public static final String SEMESTER_REGISTRATION_UPDATE_QUERY = "UPDATE `CRSDatabase`.`student` SET `is_approved` = '1' WHERE (`student_id` = ?);";
}
