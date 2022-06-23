package com.flipkart.application;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.Gender;
import com.flipkart.constant.Role;
import com.flipkart.dao.MockData;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AdminCRSMenu {

    AdminInterface adminInterface = new AdminImpl();
    CRSApplication crsApplication = new CRSApplication();
    Scanner sc = new Scanner(System.in);

    MockData data = MockData.getInstance();

    public void addCourse(){
        List<Student> st = new ArrayList<>();

        System.out.print("COURSE CODE: ");
        String courseCode = sc.next();
        System.out.print("COURSE NAME: ");
        String name = sc.next();
        System.out.print("COURSE INSTRUCTOR: ");
        String instructor = sc.next();
        System.out.print("COURSE PREREQUISITES: ");
        String prerequisites = sc.next();
        System.out.print("NUMBER OF SEATS: ");
        int seats = sc.nextInt();
        Course newCourse= new Course(courseCode,name,true,instructor,prerequisites,seats,st);
        adminInterface.addCourse(newCourse);

    }

    public void deleteCourse(){
        System.out.print("Please enter the course code to be deleted: ");
        String courseCodeDelete = sc.next();
        adminInterface.deleteCourse(courseCodeDelete);

    }

    public void GenerateScoreCard()
    {
        Scanner scan = new Scanner(System.in);
        int sid;
        System.out.println("ENTER STUDENT ID: ");
        sid=scan.nextInt();
        String sname="";
        for(Student st : data.students)
        {
            if(st.getStudentID()==sid)
            {
                sname = st.getName();
                break;
            }
        }
        System.out.println("STUDENT NAME: "+sname);
        for(StudentGrade sg: data.grade)
        {
            if(sg.getStudentID()==sid)
            {
                String code = sg.getCourseCode();
                String name = "";
                for(Course csr : data.courses)
                {
                    if(csr.getCourseCode().equals(code))
                    {
                        name = csr.getName();
                    }
                }
                System.out.println("COURSE NAME: " + name + "\tGRADE: " + sg.getGrade());
            }
        }
    }

    public void addProfessor(){
        System.out.print("USER ID: ");
        String userId = sc.next();

        System.out.print("NAME: ");
        String name = sc.next();

        System.out.println("PASSWORD: ");
        String password = sc.next();
        System.out.print("PROFESSOR ID: ");
        int professorId = sc.nextInt();
        System.out.print("DEPARTMENT: ");
        String department = sc.next();
        System.out.println("DESIGNATION: ");
        String designation= sc.next();
        System.out.print("ADDRESS: ");
        String address = sc.next();
        System.out.print("GENDER: ");
        String gender = sc.next();

        Professor newProfessor = new Professor(userId,name,password,Role.PROFESSOR,professorId,department,Gender.valueOf(gender.toUpperCase()),designation,new Date(),address);
        adminInterface.addProfessor(newProfessor);


    }

    public void approveStudents(){
        adminInterface.approveStudent();
    }

    public void createMenu() {
        System.out.println("============================================");
        System.out.println("----------------ADMIN CRS MENU-------------");
        System.out.println("============================================");
        System.out.println("1. View All Courses");
        System.out.println("2. View All Professors");
        System.out.println("3. Add new Course to Course Catalog");
        System.out.println("4. Delete a Course from Course Catalog");
        System.out.println("5. Add Professor to CRS");
        System.out.println("6. Approve Registration of Students");
        System.out.println("7. Generate Grade Card for Students");
        System.out.println("8. Logout");
        while (true) {
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    List<Course> course = adminInterface.viewCourses();
                    for(Course cs: course){
                        System.out.println(cs.getCourseCode());
                        for(Student std: cs.getEnrolled()){
                            System.out.println(std.getUserID());
                        }
                    }
                    break;
                case 2:
                    List<Professor> professor = adminInterface.viewProfessors();
                    for(Professor ps: professor){
                        System.out.println("PROFESSOR ID: "+ps.getUserID()+",  PROFESSOR NAME: "+ps.getName());
                    }
                    break;
                case 3:
                    addCourse();
                    break;

                case 4:
                    deleteCourse();
                    break;

                case 5:
                    addProfessor();
                    break;

                case 6:
                    approveStudents();
                    break;

                case 7:
                    GenerateScoreCard();
                    break;
                case 8:
                    crsApplication.createMenu();
                    break;

                default:
                    System.out.println("Wrong Selection! Please enter your choice again.");

            }
        }
    }
}
