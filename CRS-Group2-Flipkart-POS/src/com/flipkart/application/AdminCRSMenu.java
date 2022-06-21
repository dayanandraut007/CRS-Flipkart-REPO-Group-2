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

        System.out.print("Course Code:");
        String courseCode = sc.next();
        System.out.print("Course Name:");
        String name = sc.nextLine();
        System.out.print("Course Instructor:");
        String instructor = sc.nextLine();
        System.out.print("Course prerequisites:");
        String prerequisites = sc.nextLine();
        System.out.print("Number of seats:");
        int seats = sc.nextInt();
        Course newCourse= new Course(courseCode,name,true,instructor,prerequisites,seats,st);
        adminInterface.addCourse(newCourse);

    }

    public void deleteCourse(){
        System.out.print("Course Code to be Deleted:");
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
        System.out.print("UserId:");
        String userId = sc.next();

        System.out.print("Name:");
        String name = sc.next();

        System.out.println("Password:");
        String password = sc.next();
        System.out.print("ProfessorId:");
        int professorId = sc.nextInt();
        System.out.print("Department:");
        String department = sc.next();
        System.out.println("Designation:");
        String designation= sc.next();
        System.out.print("Address:");
        String address = sc.next();
        System.out.print("Gender:");
        String gender = sc.next();

        Professor newProfessor = new Professor(userId,name,password,Role.PROFESSOR,professorId,department,Gender.valueOf(gender.toUpperCase()),designation,new Date(),address);
        adminInterface.addProfessor(newProfessor);


    }

    public void approveStudents(){
        adminInterface.approveStudent();
    }

    public void createMenu() {
        System.out.println("------------Admin CRS Menu---------------");
        System.out.println("------------------------------");
        System.out.println("1. View All Courses");
<<<<<<< HEAD
        System.out.println("2. Add new Course to Course Catalog");
        System.out.println("3. Delete a Course from Course Catalog");
        System.out.println("4. Add Professor to CRS");
        System.out.println("5. Approve Registration of Students");
        System.out.println("6. Generate Grade Card for Students");
        System.out.println("7. Logout");
=======
        System.out.println("2. View All Professors");
        System.out.println("3. Add new Course to Course Catalog");
        System.out.println("4. Delete a Course from Course Catalog");
        System.out.println("5. Add Professor to CRS");
        System.out.println("6. Approve Registration of Students");

        System.out.println("7. Generate Grade Card for Students");
        System.out.println("8. Logout");
>>>>>>> 710c63e64e4fa55e0e9303eb0362d172a09dc40b
        while (true) {
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    List<Course> course = adminInterface.viewCourses();
                    for(Course cs: course){
                        System.out.println(cs.getCourseCode());

                    }
                    break;
                case 2:
                    List<Professor> professor = adminInterface.viewProfessors();
                    for(Professor ps: professor){
                        System.out.println("ProfessorId : "+ps.getProfessorId()+",  ProfessorName : "+ps.getName());

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


<<<<<<< HEAD
                case 6:
                    GenerateScoreCard();
                    //System.out.println("Write logic for generate grade card");
=======
                case 7:
                    System.out.println("Write logic for generate grade card");
>>>>>>> 710c63e64e4fa55e0e9303eb0362d172a09dc40b
                    break;

                case 8:
                    crsApplication.createMenu();
                    break;

                default:
                    System.out.println("Select the menu properly");

            }
        }
    }
}
