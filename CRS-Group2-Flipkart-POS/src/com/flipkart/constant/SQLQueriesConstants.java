package com.flipkart.constant;

public class SQLQueriesConstants {
    public static final String VIEW_COURSE_QUERY = "SELECT * FROM course";
    public static final String ADD_COURSE_QUERY = "INSERT INTO `CRSDatabase`.`course` (`course_code`, `course_name`, `prerequisite`, `seats`) VALUES (?,?,?,?)";

    public static final String STUDENT_REGISTRATION_QUERY = "INSERT INTO `CRSDatabase`.`student` (`student_id`, `student_name`, `branch`, `batch`, `address`, `is_approved`, `has_registered`, `done_payment`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static final String GET_STUDENT_BY_ID_QUERY = "SELECT * FROM `CRSDatabase`.`student` WHERE `student_id` = ?";
    public static final String ADD_COURSE_STUDENT_QUERY = "INSERT INTO `CRSDatabase`.`student_enrolled_course` (`student_id`, `course_id`) VALUES (?,?);";

    public static final String DROP_COURSE_STUDENT_QUERY = "DELETE FROM `CRSDatabase`.`student_enrolled_course` WHERE (`student_id` = ?) and (`course_id` = ?);";

    public static final String VIEW_REGISTERED_COURSES_STUDENT_QUERY = "SELECT * FROM CRSDatabase.student_enrolled_course where student_id = ?;";

    public static final String IS_APPROVED_STUDENT_QUERY = "SELECT is_approved FROM CRSDatabase.student where student_id = ?;";

    public static final String SEMESTER_REGISTRATION_STUDENT_QUERY = "SELECT count(*) FROM CRSDatabase.student_enrolled_course where student_id = ?;";

    public static final String SEMESTER_REGISTRATION_UPDATE_QUERY = "UPDATE `CRSDatabase`.`student` SET `is_approved` = '1' WHERE (`student_id` = ?);";

    //PROFESSOR QUERIES
    public static final String VIEW_TEACHING_COURSES_PROFESSOR_QUERY = "SELECT * FROM CRSDatabase.course where instructor_id = ?;";

    public static final String VIEW_ENROLLED_STUDENTS="select course.course_code,course.course_name,student_enrolled_course.student_id from course inner join student_enrolled_course on course.course_code = student_enrolled_course.course_id where course.instructor_id = ? order by course.course_code";

    public static final String CHECK_VALID_COURSES_QUERY_FOR_ADD_GRADE = "SELECT * FROM CRSDatabase.student_enrolled_course where course_id = ? and student_id=?;";

    public static final String ADD_GRADE_QUERY="INSERT INTO `CRSDatabase`.`grade_card` (`student_id`, `course_id`,`grade`) VALUES (?,?,?);";
}
