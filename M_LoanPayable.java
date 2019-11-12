
/*
Program Name: Your_Intitials_LoanPayable.java
	Author: Ming
	Date: Jul. 24, 2019 5:17:36 p.m.
Description: interface use to calculate Loan Payment
*/
public interface M_LoanPayable
{
	  final double ANNUAL_RATE_TO_MONTHLY_RATE=1.0/1200;
	  
	  public abstract double calculateLoanPayment(double studentLoandAmount,double annualPrimeInterestRate,int periodInMonth);
}
