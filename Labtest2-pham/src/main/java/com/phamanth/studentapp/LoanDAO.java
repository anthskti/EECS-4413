package com.phamanth.studentapp;

import java.util.ArrayList;
import java.util.List;

import com.phamanth.database.DatabaseConnection;
import java.sql.*;

public class LoanDAO {
	
	// Class names from labtest2 pdf
	
	
	 public List<StudentLoan> readAll() {
		 String sql = "SELECT loan_id, principal, interest, period, payment, student_id from loans";
		 List<StudentLoan> loans = new ArrayList<>();
		 
		 try (Connection conn = DatabaseConnection.connect();
			  Statement stmt = conn.createStatement();
		  	  ResultSet rs = stmt.executeQuery(sql)){
			 
			 while (rs.next()) {
				 StudentLoan loan = new StudentLoan();
				 loan.setLoanID(rs.getInt("loan_id"));
				 loan.setPrincipal(rs.getInt("principal"));
				 loan.setInterest(rs.getDouble("interest"));
				 loan.setPeriod(rs.getInt("period"));
				 loan.setPayment(rs.getDouble("payment"));
				 loan.setStudentID(rs.getInt("student_id"));
				 loans.add(loan);
			 }
			 
		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
		 }
		 return loans;		 
	 }
	 
	 // CRUD
	 
	 public void create(StudentLoan loan) {
		 String sql = "INSERT INTO loans(principal, interest, period, payment, student_id) VALUES(?,?,?,?,?)";
		 
		 try (Connection conn = DatabaseConnection.connect();
			  PreparedStatement pstmt = conn.prepareStatement(sql)) {
			 
			 double payment = DebtCalculator.computeMonthlyPayment(
					 loan.getPrincipal(),
					 loan.getInterest(), 
					 loan.getPeriod());
			 loan.setPayment(payment);
			 
			 pstmt.setInt(1, loan.getPrincipal());
			 pstmt.setDouble(2, loan.getInterest());
			 pstmt.setInt(3, loan.getPeriod());
			 pstmt.setDouble(4, payment);	 
			 pstmt.setInt(5, loan.getStudentID());
			 pstmt.executeUpdate();
			 
		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
		 }
	 }
	 
	 public StudentLoan read(int loan_id) {
		 String sql = "SELECT principal, interest, period, payment, student_id from loans WHERE loan_id = ?";
		 StudentLoan loan = null;
		 
		 try (Connection conn = DatabaseConnection.connect();
			  PreparedStatement pstmt = conn.prepareStatement(sql)) {
			 
			 // Where statement
			 pstmt.setInt(1, loan_id);
			 
			 try (ResultSet rs = pstmt.executeQuery()) {
				 if(rs.next()) {
					 loan = new StudentLoan();
					 
					 loan.setLoanID(loan_id);
					 loan.setPrincipal(rs.getInt("principal"));
					 loan.setInterest(rs.getDouble("interest"));
					 loan.setPeriod(rs.getInt("period"));
					 loan.setPayment(rs.getDouble("payment"));
					 loan.setStudentID(rs.getInt("student_id"));
				 }
			 }
		 } catch (SQLException e){
			 System.out.println(e.getMessage());
		 }
		  
		 return loan;
	 }
	 
	 public void update(int loan_id, StudentLoan studentLoan) {
		 String sql = "UPDATE loans SET principal = ?, interest = ?, period = ?, payment = ?, student_id = ? WHERE loan_id = ?";
		 
		 try (Connection conn = DatabaseConnection.connect();
			  PreparedStatement pstmt = conn.prepareStatement(sql)) {
			 
			 double payment = DebtCalculator.computeMonthlyPayment(studentLoan.getPrincipal(),
					 studentLoan.getInterest(),
					 studentLoan.getPeriod());
			 
			 studentLoan.setPayment(payment);
			 
			 // Setting Params
			 pstmt.setInt(1, studentLoan.getPrincipal());
			 pstmt.setDouble(2, studentLoan.getInterest());
			 pstmt.setInt(3, studentLoan.getPeriod());
			 pstmt.setDouble(4, payment);
			 pstmt.setInt(5, studentLoan.getStudentID());
			 
			 // WHERE statement
			 pstmt.setInt(6, loan_id); 
			 
			 // Updates
			 pstmt.executeUpdate();
			 
		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
		 } 
	 }
	 
	 public void delete(int loan_id) {
		 String sql = "DELETE FROM loans WHERE loan_id =?";
		 
		 try (Connection conn = DatabaseConnection.connect();
			  PreparedStatement pstmt = conn.prepareStatement(sql)) {
			 
			 pstmt.setInt(1, loan_id); // Sets corresponding loan_id
			 pstmt.executeUpdate(); // Deletes
			 
		 } catch (SQLException e ){
			 System.out.println(e.getMessage());
		 }
		 
	 }
}