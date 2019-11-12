
/*
Program Name: Student.java
	Author: Ming
	Date: Jul. 24, 2019 1:18:29 p.m.
Description: student class 
*/
public class Student
{
	//property
	private String studentID;
	private String surname;
	private String middleName;
	private String firstName;
	private String aptNumber;
	private String streetNumber;
	private String streetName;
	private String city;
	private String province;
	private String postalCode;
	private double cslLoanAmount;
	private double oslLoanAmount;
	// constructor
	Student(String studentID, String surname, String middleName,String firstName,String aptNumber,String streetNumber,String streetName,
	String city,String province,String postalCode, double cslLoanAmount,double oslLoanAmount)
	{
		
		this.studentID=studentID;
		this.surname=surname;
		this.middleName=middleName;
		this.firstName=firstName;
		this.aptNumber=aptNumber;
		this.streetNumber=streetNumber;
		this.streetName=streetName;
		this.city=city;
		this.province=province;
		this.postalCode=postalCode;
		this.cslLoanAmount=cslLoanAmount;
		this.oslLoanAmount=oslLoanAmount;
	}
	//getter
	public String getStudentID()
	{
		return this.studentID;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public String getMiddleName()
	{
		return this.middleName;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getAptNumber()
	{
		return this.aptNumber;
	}
	public String getStreetNumber()
	{
		return this.streetNumber;
	}
	public String getStreetName()
	{
		return this.streetName;
	}
	public String getCity()
	{
		return this.city;
	}
	public String getProvince()
	{
		return this.province;
	}
	public String getPostalCode()
	{
		return this.postalCode;
	}
	public double getCslLoanAmount()
	{
		return this.cslLoanAmount;
	}
	public double getOslLoanAmount()
	{
		return this.oslLoanAmount;
	}
	
	//setter
	public void setSurname( String newSurname)
	{
		 this.surname=newSurname;
	}
	public void setMiddleName( String newMiddleName)
	{
		 this.middleName=newMiddleName;
	}
	public void setFirstName( String newFirstName)
	{
		 this.firstName=newFirstName;
	}
	public void setAptNumber( String newAptNumber)
	{
		 this.aptNumber=newAptNumber;
	}
	public void setStreetNumber( String newStreetNumber)
	{
		 this.streetNumber=newStreetNumber;
	}
	public void setStreetName( String newStreetName)
	{
		 this.streetName=newStreetName;
	}
	public void setCity( String newCity)
	{
		 this.city=newCity;
	}
	public void setProvince( String newProvince)
	{
		 this.province= newProvince;
	}
	public void setPostalCode( String newPostalCode)
	{
		 this.postalCode=newPostalCode;
	}
	public void setCslLoanAmount( double newCslLoanAmount)
	{
		 this.cslLoanAmount=newCslLoanAmount;
	}
	public void setOslLoanAmount( double newOslLoanAmount)
	{
		 this.oslLoanAmount=newOslLoanAmount;
	}

	public String toString()
	{
		return "Student Name: "+this.middleName+", "+this.surname+" "+this.firstName+"\nStudent Number: "+this.studentID
				+"\nCSL Amount is $"+this.cslLoanAmount
				+"\nOSL Amount is $"+this.oslLoanAmount;
	}

}
