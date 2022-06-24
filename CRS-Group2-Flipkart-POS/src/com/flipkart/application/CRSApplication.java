package com.flipkart.application;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.*;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Menu class for Application (Application entry point)
 *
 * @author  JEDI-June-Program-Group-2-2022
 * @version 1.0
 * @since   June 2022
 */
public class CRSApplication {

    Scanner sc = new Scanner(System.in);
    StudentInterface studentInterface = new StudentImpl();
    ProfessorInterface professorInterface = new ProfessorImpl();

    /**
     * Method for user login
     * @throws UserNotFoundException
     */
    public void userLogin() throws UserNotFoundException {
        System.out.print("USER ID: ");
        String userid = sc.next();
        System.out.print("PASSWORD: ");
        String password = sc.next();

        UserInterface userInterface = new UserImpl();
        User usr = userInterface.login(userid,password);
        if(usr!=null){
            System.out.println("LOGIN SUCCESSFUL!");
            System.out.println(usr.getUserID());
            System.out.println(usr.getRole());
            //call menu for role based

            if(usr.getRole().name() == "STUDENT"){
                StudentCRSMenu studentCRSMenu = new StudentCRSMenu();
                Student st = studentInterface.getStudentById(usr.getUserID());
                System.out.println("Logged in by: " + st.getName() + " at time: " + LocalDateTime.now());
                studentCRSMenu.createMenu(usr.getUserID());
            }
            else if(usr.getRole().name() == "ADMIN"){
                AdminCRSMenu adminCRSMenu = new AdminCRSMenu();
                adminCRSMenu.createMenu();
            }
            else if(usr.getRole().name() == "PROFESSOR"){
                ProfessorCRSMenu professorCRSMenu  = new ProfessorCRSMenu();
                Professor st = professorInterface.getProfessorById(usr.getUserID());
                System.out.println("Logged in by: " + st.getName() + " at time: " + LocalDateTime.now());
                professorCRSMenu.createMenu(usr.getUserID());

            }
        }else{
            System.out.println("LOGIN FAILED! PLEASE TRY AGAIN.");
        }

    }

    /**
     * Method for student registration
     */
    public void studentRegistration(){
        try {
            System.out.print("USER ID: ");
            String userId = sc.next();

            System.out.print("NAME: ");
            String name = sc.next();
            System.out.print("BRANCH: ");
            String branch = sc.next();
            System.out.println("BATCH: ");
            int batch = sc.nextInt();
            System.out.print("ADDRESS: ");
            String address = sc.next();
            studentInterface.register(name, userId, null, null, batch, branch, address);
        }
        catch(UserAlreadyExistException e){
            System.out.println(e.getMessage());
        }

    }

    public void createMenu() {
        try {
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
                        try {
                            userLogin();
                        } catch (UserNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
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
        } catch (InputMismatchException e) {
            System.out.println("Input format mismatched");
            createMenu();
        }
    }


    public static void main(String[] args) {

        CRSApplication crsApplication = new CRSApplication();
        crsApplication.createMenu();
    }
}
