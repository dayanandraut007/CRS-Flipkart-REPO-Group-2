package com.flipkart.controller;

import com.flipkart.bean.Student;
import com.flipkart.bean.User;
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
            return Response.status(200).entity(std).build();
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
    public Response semesterRegistration(@QueryParam("id") String userId)
    {
        try
        {
            if(studentInterface.semesterRegistration(userId)) {
                return Response.status(200).entity("Semester Registration of "+userId+" is successful").build();
            }
        }
        catch (PaymentFailedException | SemesterRegistrationException e)
        {
            e.getMessage();
            return Response.status(500).entity("SEMESTER REGISTRATION FAILED! PLEASE TRY AGAIN.").build();
        }
        return Response.status(500).entity("SEMESTER REGISTRATION FAILED! PLEASE TRY AGAIN.").build();
    }

    @GET
    @Path("/getStudent/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getStudentById(@PathParam("id") String studentId) {
        try {
            Student st = studentInterface.getStudentById(studentId);
            return Response.status(200).entity(st).build();
        }
        catch (UserNotFoundException e) {
            return Response.status(500).entity("Fetch student FAILED! PLEASE TRY AGAIN.").build();
        }
    }

    @GET
    @Path("/approved/{id}")
    public Response isApproved(@PathParam("id") String userId)
    {
        try
        {
            if(studentInterface.isApproved(userId))
                return Response.status(200).entity("Student with user ID "+userId+" is Approved").build();
            else
                return Response.status(200).entity("Student with user ID "+userId+" is not Approved").build();
        }
        catch (Exception e)
        {
            e.getMessage();
            return Response.status(500).entity("PLEASE TRY AGAIN.").build();
        }
    }

    @POST
    @Path("/dropcourse/{sid}/{cid}")
    public Response dropCourse(@PathParam("sid")String studentId, @PathParam("cid") String courseCode)
    {
        return null;
    }
}
