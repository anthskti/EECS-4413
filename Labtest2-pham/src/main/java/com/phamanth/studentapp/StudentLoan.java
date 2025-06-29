package com.phamanth.studentapp;

public class StudentLoan {
	
	private int loan_id;
	private int principal;
	private double interest;
	private int period;
	private double payment = -1; // for default value
	private int student_id;
	
	// getters and setters 
	
	
	public int getLoanID() {
		return loan_id;
	}
	public void setLoanID(int loan_id) {
		this.loan_id = loan_id;
	}
	public int getPrincipal() {
		return principal;
	}
	public void setPrincipal(int principal) {
		this.principal = principal;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public int getStudentID() {
		return student_id;
	}
	public void setStudentID(int student_id) {
		this.student_id = student_id;
	}
	
}