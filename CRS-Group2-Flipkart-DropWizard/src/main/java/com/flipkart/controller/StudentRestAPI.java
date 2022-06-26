package com.flipkart.controller;

import com.flipkart.bean.Student;
import com.flipkart.constant.Role;
import com.flipkart.exception.PaymentFailedException;
import com.flipkart.exception.SemesterRegistrationException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("/student")
public class StudentRestAPI {

    @GET
    @Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployees() {
        return "my dropwizard service";
    }
    StudentInterface studentInterface = new StudentImpl();
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(Student student)
    {
        try
        {
            Student std = studentInterface.register(student.getName(),student.getUserID(),student.getPassword(), "F",student.getBatch(),student.getBranch(),student.getAddress());
            return Response.ok(std).build();
        }
        catch (UserAlreadyExistException e)
        {
            e.getMessage();
            Response.status(500).entity(e.getMessage()).build();
        }
        return Response.status(500).entity("REGISTRATION FAILED! PLEASE TRY AGAIN.").build();
    }

    @POST
    @Path("/registration")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response semesterRegistration(@QueryParam("id") String userId)
    {
        System.out.println("ID="+userId);
        try
        {
            if(studentInterface.semesterRegistration(userId)) {
                return Response.status(200).entity(userId).build();
            }
        }
        catch (PaymentFailedException | SemesterRegistrationException e)
        {
            e.getMessage();
            return Response.status(500).entity("SEMESTER REGISTRATION FAILED! PLEASE TRY AGAIN.").build();
        }
        return Response.status(500).entity("SEMESTER REGISTRATION FAILED! PLEASE TRY AGAIN.").build();
    }


}