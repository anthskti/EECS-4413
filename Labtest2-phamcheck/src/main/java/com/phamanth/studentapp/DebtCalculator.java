package com.phamanth.studentapp;


public class DebtCalculator {
	
	public static double computeMonthlyPayment(int principal, double interest, int period) {
		double monthlyPayment = (principal * interest/100/12) / (1- (Math.pow((1+interest/100/12), -period)));
		
		return monthlyPayment;
	}
}