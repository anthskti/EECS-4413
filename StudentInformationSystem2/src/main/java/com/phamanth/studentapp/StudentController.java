package com.phamanth.studentapp;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
//import jakarta.ws.rs.GET;
//import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.servlet.ServletContext;
import jakarta.ws.rs.core.Context;


@Path("/students")

public class StudentController {
	private StudentDAO studentDAO = new StudentDAO();
	
	@GET
	 @Path("/totalApiCalls")
		 public Response getTotalApiCalls(@Context ServletContext context) {
			Integer counter = (Integer) context.getAttribute("apiCallCounter");
				 
			/* retrieve counter from application context. 
			 * Hint: You can inject the ServletContext in your REST method, 
			 * similar to how you inject HttpServletRequest in doGet in the previos labs. */;
			 
			 if (counter == null) {
				 	counter = 0; // Handle the case where the counter attribute is not set
			 }
		 return Response.ok(counter.toString()).build();
	 }
	
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
}
