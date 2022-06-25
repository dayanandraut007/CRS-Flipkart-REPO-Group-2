/**
 * @author : jedi2022-Group2
 * projecr : CRS-Group2-Flipkart
 */
package com.flipkart.controller;

import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.StudentGrade;
import com.flipkart.exception.CourseAlreadyPresentException;
import com.flipkart.exception.CourseNotFoundException;
import com.flipkart.exception.UserAlreadyExistException;
import com.flipkart.exception.UserNotFoundException;
import com.flipkart.service.AdminImpl;
import com.flipkart.service.AdminInterface;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.RequestWrapper;
import java.util.List;

@Path("/admin")
public class AdminRestAPI {

    AdminInterface adminInterface = new AdminImpl();

    @POST
    @Path("/addCourse")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCourse(@Valid Course course) throws ValidationException {
        try
        {
            adminInterface.addCourse(course);
            return Response.status(201).entity("Course with courseCode: " + course.getCourseCode() + " added to catalog").build();
        }
        catch(CourseAlreadyPresentException | UserNotFoundException e)
        {
            return Response.status(409).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/viewAllCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> viewAllCourses() {

        return adminInterface.viewCourses();

    }

    @GET
    @Path("/generateScoreCard")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StudentGrade> generateScoreCard(
            @NotNull
            @QueryParam("studentId") String studentId
    ){
        try {
            return adminInterface.generateGradeCard(studentId);
        }
        catch(UserNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @POST
    @Path("/addProfessor")
    @Consumes("application/json")
    public Response addProfessor(@Valid Professor professor) throws ValidationException{

        try {

            adminInterface.addProfessor(professor);
            return Response.status(201).entity("Professor with professorId: " + professor.getUserID() + " added").build();

        } catch (UserAlreadyExistException e) {

            return Response.status(409).entity(e.getMessage()).build();

        }

    }

    @GET
    @Path("/viewProfessors")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> viewProfessors() {

        return adminInterface.viewProfessors();
    }

    @PUT
    @Path("/deleteCourse")
    public Response deleteCourse(
            @NotNull
            @QueryParam("courseCode") String courseCode) throws ValidationException{

        try {

            adminInterface.deleteCourse(courseCode);
            return Response.status(201).entity("Course with courseCode: " + courseCode + " deleted from catalog").build();

        } catch (CourseNotFoundException e) {

            return Response.status(409).entity(e.getMessage()).build();

        }
    }

    @GET
    @Path("/viewPendingAdmissions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> viewPendingAdmissions() {
        //System.out.println(ls.size());
        return adminInterface.viewPendingAdmissions();

    }

    @PUT
    @Path("/approveStudent")
    public Response approveStudent(
            @NotNull
            @QueryParam("userId") String studentId) throws ValidationException{

        try {

            adminInterface.approveStudent(studentId);
            return Response.status(201).entity("Student with studentId: " + studentId + " approved").build();

        } catch (UserNotFoundException e) {

            return Response.status(409).entity(e.getMessage()).build();

        }

    }

}
