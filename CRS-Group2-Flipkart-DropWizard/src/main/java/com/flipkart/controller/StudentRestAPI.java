package com.flipkart.controller;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.bean.User;
import com.flipkart.constant.Role;
import com.flipkart.exception.*;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.StudentImpl;
import com.flipkart.service.StudentInterface;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


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
    @Path("/registration/{id}")
    public Response semesterRegistration(@PathParam("id") String userId)
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
    public Response dropCourse(@PathParam("sid")String userId, @PathParam("cid") String courseCode)
    {
        try
        {
            if(studentInterface.dropCourse(userId,courseCode))
                return Response.status(200).entity("Dropped course "+courseCode+" of Student with user ID "+userId+" successfully").build();
            else
                return Response.status(500).entity("Couldn't drop course "+courseCode).build();
        }
        catch (CourseAlreadyRegisteredException | CourseNotAddedException e)
        {
            e.getMessage();
            return Response.status(500).entity("Couldn't drop course "+courseCode).build();
        }
    }

    @GET
    @Path("/registeredcourses/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewRegisteredCourses(@PathParam("id") String userId)
    {
        try
        {
            List<String> registeredCourses = studentInterface.viewRegisteredCourses(userId);
            return Response.status(200).entity(registeredCourses).build();
        }
        catch (Exception e)
        {
            e.getMessage();
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/gradecard/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewGradeCard(@PathParam("id") String userId)
    {
        try
        {
            List<StudentGrade> registeredCourses = studentInterface.viewGradeCard(userId);
            return Response.status(200).entity(registeredCourses).build();
        }
        catch (Exception e)
        {
            e.getMessage();
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
    @GET
    @Path("/addedcourses/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAddedCourses(@PathParam("id") String userId)
    {
        try
        {
            List<List<String>> addedCourses = studentInterface.viewAddedCourses(userId);
            return Response.status(200).entity(addedCourses).build();
        }
        catch (Exception e)
        {
            e.getMessage();
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/addcourse/{sid}/{cid}/{isprimary}")
    public Response addCourse(@PathParam("sid")String studentId, @PathParam("cid")String courseCode, @PathParam("isprimary")String primary) {
        try {
            if (studentInterface.addCourse(studentId, courseCode, primary)) {
                Response.status(200).entity("Course code " + courseCode + " added").build();
            } else {
                return Response.status(500).entity("PLEASE TRY AGAIN.").build();
            }
        } catch (Exception e) {
            return Response.status(500).entity("PLEASE TRY AGAIN.").build();
        }
        return Response.status(500).entity("PLEASE TRY AGAIN.").build();
    }
    @GET
    @Path("/allcourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Response viewAllCourses()
    {
        try
        {
            List<Course> allCourses = studentInterface.viewAllCourses();
            return Response.status(200).entity(allCourses).build();
        }
        catch (Exception e)
        {
            e.getMessage();
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/makepayment")
    public Response makePayment(@QueryParam("id")String studentId,
                                @QueryParam("tid") String transactionId,
                                @QueryParam("mop") String modeOfPayment,
                                @QueryParam("amt") Float amount)
    {
        try
        {
            if(studentInterface.makePayment(studentId,transactionId,modeOfPayment,amount))
                return Response.status(200).entity("Payment Successful of student "+studentId).build();
            else
                return Response.status(500).entity("Payment Failed").build();
        }
        catch(CourseLimitException | PaymentFailedException e)
        {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

}
