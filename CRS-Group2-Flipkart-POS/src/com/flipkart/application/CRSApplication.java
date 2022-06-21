package com.flipkart.application;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
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
        System.out.print("USER ID: ");
        String userid = sc.next();
        System.out.print("PASSWORD: ");
        String password = sc.next();

        UserInterface userInterface = new UserImpl();
        User usr = userInterface.login(userid,password);
        if(usr!=null){
            System.out.println("LOGIN SUCCESSFUL!");
            System.out.println(usr.getRole().name());
            //call menu for role based
            if(usr.getRole().name() == "STUDENT"){
                StudentCRSMenu studentCRSMenu = new StudentCRSMenu();
                studentCRSMenu.createMenu();
            }
            else if(usr.getRole().name() == "ADMIN"){
                AdminCRSMenu adminCRSMenu = new AdminCRSMenu();
                adminCRSMenu.createMenu();
            }
            else if(usr.getRole().name() == "PROFESSOR"){
                ProfessorCRSMenu professorCRSMenu  = new ProfessorCRSMenu();
                professorCRSMenu.createMenu();

            }
        }else{
            System.out.println("LOGIN FAILED! PLEASE TRY AGAIN.");
        }

    }

    public void studentRegistration(){

        System.out.print("USER ID: ");
        String userId = sc.next();

        System.out.print("NAME: ");
        String name = sc.next();

        System.out.println("PASSWORD: ");
        String password = sc.next();
        System.out.print("BRANCH: ");
        String branch = sc.next();
        System.out.println("BATCH: ");
        int batch= sc.nextInt();
        System.out.print("ADDRESS: ");
        String address = sc.next();
        studentInterface.register(name,userId,password,"",batch,branch,address);

    }

    public void createMenu(){
        System.out.println("============================================");
        System.out.println("---------------CRS APPLICATION-------------");
        System.out.println("============================================");
        System.out.println("1. Login");
        System.out.println("2. Student Registration");
        System.out.println("3. Update Password");
        System.out.println("4. Exit");
        while (true) {
            System.out.print("Please enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    userLogin();
                    break;
                case 2:
                    studentRegistration();
                    break;
                case 3:
                    System.out.println("Write logic for update password");
                    break;
                case 4:
                    System.exit(0);

                default:
                    System.out.println("Wrong Selection! Please enter your choice again.");

            }
        }
    }



    public static void main(String[] args) {

        CRSApplication crsApplication = new CRSApplication();
        crsApplication.createMenu();
    }
}
