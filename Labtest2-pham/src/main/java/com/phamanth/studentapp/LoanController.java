package com.phamanth.studentapp;

import jakarta.servlet.ServletContext;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List; 

@Path("/loans")

public class LoanController {
	private LoanDAO LoanDAO = new LoanDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentLoan> getAllLoans() {
		return LoanDAO.readAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.APPLICATION_JSON)
	 public void createStudentLoan(StudentLoan loan) {
		LoanDAO.create(loan);
	 }
	
	@GET
	@Path("/{loan_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentLoan getStudentLoan(@PathParam("loan_id") int loan_id) {
		return LoanDAO.read(loan_id);
	}
	
	@PUT
	@Path("/{loan_id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateStudentLoan(@PathParam("loan_id") int loan_id, StudentLoan loan) {
		LoanDAO.update(loan_id, loan);
	}
	
	@DELETE
	@Path("/{loan_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStudentLoan(@PathParam("loan_id") int loan_id) {
		LoanDAO.delete(loan_id);
	}
	
	// idk about this part
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