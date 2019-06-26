package com.bridgeit.ObjectOrintedPrograming;

public class Patient {
	String Name,MobileNumber;
	int Id,Age;
	/*
	 * @purpose : to initialize class members
	 */
	Patient()
	{
		Name=MobileNumber="";
		Id=Age=0;
	}
	Patient(String Name,String MobileNumber,int Id,int Age)
	{
		this.Name=Name;
		this.MobileNumber=MobileNumber;
		this.Id=Id;
		this.Age=Age;
	}
	public void setName(String Name)
	{
		this.Name=Name;
	}
	public String getName()
	{
		return Name;
	}
	public void setMobileNumber(String MobileNumber)
	{
		this.MobileNumber=MobileNumber;
	}
	public String getMobileNumber()
	{
		return MobileNumber;
	}
	public void setId(int Id)
	{
		this.Id=Id;
	}
	public int getId()
	{
		return Id;
	}
	public void setAge(int Age)
	{
		this.Age=Age;
	}
	public int getAge()
	{
		return Age;
	}
}
