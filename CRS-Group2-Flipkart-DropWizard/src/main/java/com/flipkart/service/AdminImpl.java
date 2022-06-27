package com.flipkart.service;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.dao.AdminDaoImpl;
import com.flipkart.dao.AdminDaoInterface;

import com.flipkart.dao.StudentDaoImpl;
import com.flipkart.dao.StudentDaoInterface;
import com.flipkart.exception.*;

import java.util.List;


/**
 * This class implements the AdminInterface interface
 * to provide all the admin functionality implementations.
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class AdminImpl implements AdminInterface {

    CourseInterface courseInterface = new CourseImpl();
    AdminDaoInterface adminDaoInterface = AdminDaoImpl.getInstance();
    StudentDaoInterface studentDaoInterface = StudentDaoImpl.getInstance();

    /**
     * Method to delete course
     *
     * @param courseCode
     * @return true if added successfully, else false
     * @throws CourseNotFoundException
     */
    @Override
    public boolean deleteCourse(String courseCode) throws CourseNotFoundException {
        boolean status = adminDaoInterface.findCourse(courseCode);
        if (!status) {
            throw new CourseNotFoundException(courseCode);
        }
        adminDaoInterface.deleteCourse(courseCode);
        return true;
    }

    /**
     * Method to add course in the catalogue
     *
     * @param course
     * @return true if added successfully, else false
     * @throws CourseAlreadyPresentException
     * @throws UserNotFoundException
     */
    @Override
    public boolean addCourse(Course course) throws CourseAlreadyPresentException, UserNotFoundException {
        boolean status = adminDaoInterface.findCourse(course.getCourseCode());
        if (status) {
            throw new CourseAlreadyPresentException();
        }
        boolean status1 = adminDaoInterface.findUser(course.getInstructor());
        if (!status1) {
            throw new UserNotFoundException(course.getInstructor(), "Professor");
        }
        adminDaoInterface.addCourse(course);
        return true;
    }

    /**
     * Method to view Pending admissions
     *
     * @return list of students pending for admission
     */
    @Override
    public List<Student> viewPendingAdmissions() {
        return adminDaoInterface.viewPendingAdmissions();
    }

    /**
     * Method to approve student for login
     */
    @Override
    public void approveStudent(String studentId) throws UserNotFoundException {
        Student st = studentDaoInterface.getStudentById(studentId);
        if (st==null) {
            throw new UserNotFoundException(studentId,"student");
        }
        adminDaoInterface.approveStudent(studentId);
    }

    /**
     * Method to add Professor
     *
     * @param professor
     * @throws UserAlreadyExistException
     */
    @Override
    public void addProfessor(Professor professor) throws UserAlreadyExistException {
        boolean status = adminDaoInterface.findUser(professor.getUserID());
        if (status) {
            throw new UserAlreadyExistException(professor.getUserID(), "Professor");
        }
        adminDaoInterface.addProfessor(professor);
    }

    /**
     * Method to assign course to professor
     *
     * @param courseCode
     * @param professorId
     */
    @Override
    public void assignCourse(String courseCode, String professorId) {

    }

    /**
     * Method to view all courses in the catalogue
     *
     * @return list of courses
     */
    @Override
    public List<Course> viewCourses() {
        return adminDaoInterface.viewCourses();
    }

    /**
     * Method to view all professors
     *
     * @return list of professors
     */
    @Override
    public List<Professor> viewProfessors() {
        return adminDaoInterface.viewProfessors();
    }

    /**
     * Method to generate grade card of student
     *
     * @param userId
     * @return list of courses with grades assigned
     * @throws UserNotFoundException
     */
    @Override
    public List<StudentGrade> generateGradeCard(String userId) throws UserNotFoundException {
        boolean status = adminDaoInterface.findUser(userId);
        if (!status) {
            throw new UserNotFoundException(userId, "Student");
        }
        return adminDaoInterface.generateScoreCard(userId);
    }

    /**
     * Method to notify course change
     */
    @Override
    public void notifyCourseChange() {

    }

}
