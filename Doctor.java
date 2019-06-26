package com.bridgeit.ObjectOrintedPrograming;

public class Doctor {
	String Name,Speciality,Availability;
	int Id;
	/*
	 * @purpose : to initialize class members
	 */
	Doctor()
	{
		Name=Speciality=Availability="";
		Id=0;
	}
	Doctor(String Name,int Id,String Specaility,String Availability)
	{
		this.Name=Name;
		this.Speciality=Specaility;
		this.Availability=Availability;
		this.Id=Id;
	}
	
	public void setName(String Name)
	{
		this.Name=Name;
	}
	public String getName()
	{
		return this.Name;
	}
	public void setId(int Id)
	{
		this.Id=Id;
	}
	public int getId()
	{
		return this.Id;
	}
	public void setSpecialization(String Speciality)
	{
		this.Speciality=Speciality;
	}
	public String getSpecialization()
	{
		return this.Speciality;
	}
	public void setAvailabilty(String Availability)
	{
		this.Availability=Availability;
	}
	public String getAvailability()
	{
		return Availability;
	}
}
