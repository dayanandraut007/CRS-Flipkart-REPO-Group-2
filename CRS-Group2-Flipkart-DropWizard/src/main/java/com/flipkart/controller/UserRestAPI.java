package com.flipkart.controller;

import com.flipkart.application.AdminCRSMenu;
import com.flipkart.application.ProfessorCRSMenu;
import com.flipkart.application.StudentCRSMenu;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.User;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;


@Path("/user")
public class UserRestAPI {

    UserInterface userInterface = new UserImpl();
    StudentInterface studentInterface = new StudentImpl();
    ProfessorInterface professorInterface = new ProfessorImpl();

    @POST
    @Path("/login") // /user/login?userId=daya&password=pass
    public Response verifyCredentials(
            @NotNull
            @QueryParam("userId") String userId,
            @NotNull
            @Size(min = 4 , max = 20 , message = "Password length should be between 4 and 20 characters")
            @QueryParam("password") String password) throws ValidationException {

        try
        {
            User usr = userInterface.login(userId,password);
            if(usr!=null){

                if(usr.getRole().name() == "STUDENT"){
                    Student st = studentInterface.getStudentById(usr.getUserID());
                    String msg = "Hello, " + st.getName() + ". You have logged in as student in: " + LocalDateTime.now();
                    return Response.status(200).entity("msg").build();

                }
                else if(usr.getRole().name() == "ADMIN"){
                    String msg = "Hello, admin. You have logged in as admin in: " + LocalDateTime.now();
                    return Response.status(200).entity("msg").build();

                }
                else if(usr.getRole().name() == "PROFESSOR"){
                    ProfessorCRSMenu professorCRSMenu  = new ProfessorCRSMenu();
                    Professor st = professorInterface.getProfessorById(usr.getUserID());
                    String msg = "Hello, " + st.getName() + ". You have logged in as professor in: " + LocalDateTime.now();
                    return Response.status(200).entity("msg").build();


                }
            }else{
                System.out.println("LOGIN FAILED! PLEASE TRY AGAIN.");
                return Response.status(500).entity("LOGIN FAILED! PLEASE TRY AGAIN.").build();
            }
        }
        catch (UserNotFoundException ex) {
            return Response.status(500).entity(ex.getMessage()).build();
        }

        return Response.status(500).entity("LOGIN FAILED! PLEASE TRY AGAIN.").build();

    }
}
