package com.flipkart.application;

import com.flipkart.bean.Student;
import com.flipkart.constant.Role;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.UserImpl;
import com.flipkart.service.UserInterface;

import java.util.Scanner;

public class CRSApplication {

    Scanner sc = new Scanner(System.in);
    StudentInterface studentInterface = new StudentImpl();
    public void userLogin(){
        System.out.print("Userid: ");
        String userid = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        UserInterface userInterface = new UserImpl();
        Role role = userInterface.login(userid,password);
        if(role!=null){
            System.out.println("Login successful");
            System.out.println(role.name());
            //call menu for role based
            if(role.name() == "STUDENT"){
                StudentCRSMenu studentCRSMenu = new StudentCRSMenu();
                studentCRSMenu.createMenu();
            }
            else if(role.name() == "ADMIN"){
                AdminCRSMenu adminCRSMenu = new AdminCRSMenu();
                adminCRSMenu.createMenu();
            }
            else if(role.name() == "PROFESSOR"){
                ProfessorCRSMenu professorCRSMenu  = new ProfessorCRSMenu();
                professorCRSMenu.createMenu();

            }
        }else{
            System.out.println("Login failed");
        }

    }

    public void studentRegistration(){

        System.out.print("UserId:");
        String userId = sc.next();

        System.out.print("Name:");
        String name = sc.next();

        System.out.println("Password:");
        String password = sc.next();
        System.out.print("Branch:");
        String branch = sc.next();
        System.out.println("Batch:");
        int batch= sc.nextInt();
        System.out.print("Address:");
        String address = sc.next();
        studentInterface.register(name,userId,password,"",batch,branch,address);

    }



    public static void main(String[] args) {

        CRSApplication crsApplication = new CRSApplication();
        System.out.println("Welcome to CRS Application");
        System.out.println("------------------------------");
        System.out.println("1. Login");
        System.out.println("2. Registration  of Student");
        System.out.println("3. Update Password");
        System.out.println("4. Exit");
        while (true) {
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:

                    crsApplication.userLogin();
                    break;
                case 2:
                    crsApplication.studentRegistration();
                    System.out.println("Write logic for Registration");
                    break;

                case 3:
                    System.out.println("Write logic for update password");
                    break;

                case 4:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Select the menu properly");

            }
        }
    }
}
