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



    //student
    public static final String VIEW_ADDED_COURSES_STUDENT_QUERY = "SELECT * FROM CRSDatabase.student_enrolled_course where student_id =?";
    public static final String VIEW_REGISTERED_COURSES_STUDENT_QUERY = "SELECT * FROM CRSDatabase.student_enrolled_course as t1 inner join CRSDatabase.student as t2 where t1.student_id=t2.student_id and t1.student_id = ? and t2.has_registered=1;";

    public static final String ADD_COURSE_STUDENT_QUERY = "INSERT INTO `CRSDatabase`.`student_enrolled_course` (`student_id`, `course_id`,`primary`) VALUES (?,?,?);";
    public static final String UPDATE_COURSE_STUDENT_QUERY = "update course set seats=seats-1 where course_code=? ";
    public static final String CHECK_AVAILABLE_SEATS = "SELECT seats from CRSDatabase.course where course_code = ?";
    public static final String DROP_COURSE_STUDENT_QUERY = "DELETE FROM `CRSDatabase`.`student_enrolled_course` WHERE (`student_id` = ?) and (`course_id` = ?);";
    public static final String UPDATE_DROP_COURSE_STUDENT_QUERY = "update course set seats=seats+1 where course_code=? ";
    public static final String INSERT_IN_GRADE_CARD = "insert into grade_card (student_id,course_id,grade) values (?,?,null)";
    public static final String VIEW_GRADE_CARD = "select * from grade_card where student_id=?";

}
