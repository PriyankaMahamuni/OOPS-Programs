package com.bridgeit.ObjectOrintedPrograming;

public class Customer {
	private String Name;
	private int InfosysShares;
	private int GoogleShares;
	private int CapgeminiShares;
	Customer()
	{
		Name="";
		InfosysShares=GoogleShares=CapgeminiShares=0;
	}
	Customer(String Name,int InfosysShares,int GoogleShares,int CapgeminiShares)
	{
		this.Name=Name;
		this.InfosysShares=InfosysShares;
		this.GoogleShares=GoogleShares;
		this.CapgeminiShares=CapgeminiShares;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getInfosysShares() {
		return InfosysShares;
	}
	public void setInfosysShares(int infosysShares) {
		InfosysShares = infosysShares;
	}
	public int getGoogleShares() {
		return GoogleShares;
	}
	public void setGoogleShares(int googleShares) {
		GoogleShares = googleShares;
	}
	public int getCapgeminiShares() {
		return CapgeminiShares;
	}
	public void setCapgeminiShares(int capgeminiShares) {
		CapgeminiShares = capgeminiShares;
	}
}
