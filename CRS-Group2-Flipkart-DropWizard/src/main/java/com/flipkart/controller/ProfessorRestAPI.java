package com.flipkart.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
    @Path("/viewAssignedStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EnrolledStudent> viewAssignedStudents(
            @NotNull
            @QueryParam("profId") String profId) throws ValidationException	{

        List<EnrolledStudent> students=new ArrayList<EnrolledStudent>();
        try
        {
            students=professorInterface.viewAssignedStudents(profId);
        }
        catch(Exception ex)
        {

            return null;
        }
        return students;
    }

    @GET
    @Path("/viewTeachingCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewTeachingCourses(
            @NotNull
            @QueryParam("profId") String profId) throws ValidationException	{

        List<Course> courses;
        try
        {
            courses=professorInterface.viewTeachingCourses(profId);
        }
        catch(Exception ex)
        {
            return null;
        }
        return courses;

    }

    @POST
    @Path("/addGrade")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addGrade(
            @Valid StudentGrade grade,
            @NotNull
            @QueryParam("profId") String profId
            ) throws ValidationException  	{

        try
        {

            boolean temp = professorInterface.addGrade(profId, grade.getCourseCode(), grade.getStudentID(),  grade.getGrade().toString());
            if(!temp)
            {
                System.out.println("SOMETHING WENT WRONG! PLEASE TRY AGAIN.");
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
