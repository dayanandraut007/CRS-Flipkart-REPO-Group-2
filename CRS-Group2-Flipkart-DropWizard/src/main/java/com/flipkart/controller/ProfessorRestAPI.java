package com.flipkart.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.StudentGrade;
import com.flipkart.constant.Grade;
import com.flipkart.exception.CourseNotAssignedToProfessorException;
import com.flipkart.exception.StudentCourseNotMatchedException;
import org.hibernate.validator.constraints.Email;


import com.flipkart.bean.Course;
import com.flipkart.bean.EnrolledStudent;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorImpl;

@Path("/professor")
public class ProfessorRestAPI {

    ProfessorInterface professorInterface = new ProfessorImpl();

    @GET
    @Path("/assignedstudents/{profid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnrolledStudent> viewAssignedStudents(
            @NotNull
            @PathParam("profid") String profid) throws ValidationException	{

        List<EnrolledStudent> students=new ArrayList<EnrolledStudent>();
        try
        {
            students=professorInterface.viewAssignedStudents(profid);
        }
        catch(Exception ex)
        {

            return null;
        }
        return students;
    }

    @GET
    @Path("/assignedcourses/{profid}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewTeachingCourses(
            @NotNull
            @PathParam("profid") String profid) throws ValidationException	{

        List<Course> courses;
        try
        {
            courses=professorInterface.viewTeachingCourses(profid);
        }
        catch(Exception ex)
        {
            return null;
        }
        return courses;

    }

    @POST
    @Path("/add/grade/{profid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGrade(
            @Valid StudentGrade grade,
            @NotNull
            @PathParam("profid") String profid
            ) throws ValidationException  	{

        try
        {

            boolean temp = professorInterface.addGrade(profid, grade.getCourseCode(), grade.getStudentID(),  grade.getGrade().toString());
            if(!temp)
            {
                //System.out.println("SOMETHING WENT WRONG! PLEASE TRY AGAIN.");
                return Response.status(500).entity("SOMETHING WENT WRONG! PLEASE TRY AGAIN.").build();
            }


        }
        catch(CourseNotAssignedToProfessorException | StudentCourseNotMatchedException ex)
        {
            return Response.status(500).entity(ex.getMessage()).build();
        }

        return Response.status(200).entity( "Grade updated for student: "+grade.getStudentID()).build();

    }


}
