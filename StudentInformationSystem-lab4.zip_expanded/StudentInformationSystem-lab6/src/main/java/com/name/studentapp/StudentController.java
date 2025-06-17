package com.name.studentapp;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List; 

  

@Path("/students") 

public class StudentController { 

    private StudentDAO studentDAO = new StudentDAO(); 
    
  

    @GET 

    @Produces(MediaType.APPLICATION_JSON) 

    public List<Student> getAllStudents() { 

        return studentDAO.readAll(); 

    } 

  

    @POST 

    @Consumes(MediaType.APPLICATION_JSON) 

    @Produces(MediaType.APPLICATION_JSON) 

    public void createStudent(Student student) { 

        studentDAO.create(student); 

    } 

  

    @GET 

    @Path("/{id}") 

    @Produces(MediaType.APPLICATION_JSON) 

    public Student getStudent(@PathParam("id") int id) { 

        return studentDAO.read(id); 

    } 

  

    @PUT 

    @Path("/{id}") 

    @Consumes(MediaType.APPLICATION_JSON) 

    @Produces(MediaType.APPLICATION_JSON) 

    public void updateStudent(@PathParam("id") int id, Student student) { 

        studentDAO.update(id, student); 

    } 

  

    @DELETE 

    @Path("/{id}") 

    @Produces(MediaType.APPLICATION_JSON) 

    public void deleteStudent(@PathParam("id") int id) { 

        studentDAO.delete(id); 

    }
    
    @GET 

    @Path("/totalApiCalls") 

    public Response getTotalApiCalls(@Context ServletContext servletContext) { 
    	
  
        Integer counter =  (Integer) servletContext.getAttribute("apiCallCounter"); /* retrieve counter from application context */; 

        if (counter == null) { 

            counter = 0; // Handle the case where the counter attribute is not set 

        } 

        return Response.ok(counter.toString()).build(); 

    } 

} 