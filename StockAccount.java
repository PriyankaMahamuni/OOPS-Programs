package com.bridgeit.ObjectOrintedPrograming;

import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class StockAccount implements StockInfo{
	 static Scanner scannerObject=new Scanner(System.in);
	ObjectMapper mapper=new ObjectMapper();
	CompanyShares companyShares=new CompanyShares();
	Customer customer=new Customer();
	public void StockAccount(String FileName) 
	{
		//StockUtility.addAccount(FileName);
	}
	public double valueOf() 
	{
		try
		{
			List<CompanyShares> CompanySharesList=mapper.readValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/CompanyShares.json"),new TypeReference<List<CompanyShares>>() {});
			List<Customer> CustomerList=mapper.readValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/Customer.json"), new TypeReference<List<Customer>>() {});
			System.out.println("Enter Person Name : ");
			String person=getString();
			int flag=StockUtility.searchPerson(person,CustomerList);
			if(flag==1)
			{
				if(CompanySharesList.get(0)!=null)
				{
					double infosysAmount=CompanySharesList.get(flag).getPrice()*customer.getInfosysShares();
					double googleAmount=CompanySharesList.get(flag).getPrice()*customer.getGoogleShares();
					double capgeminiAmount=CompanySharesList.get(flag).getPrice()*customer.getCapgeminiShares();
					double TotalAmount=infosysAmount+googleAmount+capgeminiAmount;
					System.out.println("Total Amount of "+person+" : "+TotalAmount);
					return TotalAmount;
				}
				else
				{
					System.out.println("Companies shares are not found");
				}
					
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0.0;
	}
	public void buy(int amount,String Symbol)
	{
		try
		{
			List<CompanyShares> CompanySharesList=mapper.readValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/CompanyShares.json"),new TypeReference<List<CompanyShares>>() {});
			List<Customer> CustomerList=mapper.readValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/Customer.json"), new TypeReference<List<Customer>>() {});
			System.out.println("Enter Person Name : ");
			String person=getString();
			int flag=StockUtility.searchPerson(person,CustomerList);
			int stockIndex = StockUtility.searchSharesBySymbol(Symbol, CompanySharesList);
			String stackSymbol = null;
			CompanyShares companyShares = null;
			if (flag == 1) {

				companyShares = CompanySharesList.get(stockIndex);
				int noOfShares = companyShares.getNo_OF_Shares();
				companyShares.setNo_OF_Shares(noOfShares - amount);
				stackSymbol = companyShares.getShareSymbol();
				Customer customer = CustomerList.get(flag);
				if (stockIndex == 0) {
					int value = customer.getInfosysShares();
					customer.setInfosysShares(value + amount);
				}
				if (stockIndex == 1) {
					int value = customer.getGoogleShares();
					customer.setGoogleShares(value + amount);
				}
				if (stockIndex == 2) {
					int value = customer.getCapgeminiShares();
					customer.setCapgeminiShares(value + amount);
				} else {
					System.err.println("Stock Not Found ");
				}
			}
			System.out.println("\nStock Details");
			System.out.printf("%-15s %-20s %-20s\n", "Company_Name", "NO._OF Stocks", "Price");
			System.out.println(CompanySharesList.get(stockIndex).toString());
			System.out.printf("\n%-15s %-20s %-20s %-20s\n", "Cust. Name", "Infosys(Shares)", "Google(Shares)",
					"Capgemini(Shares)");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void sell(int amount,String Symbol)
	{
		try {
			List<CompanyShares> CompanySharesList=mapper.readValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/CompanyShares.json"),new TypeReference<List<CompanyShares>>() {});
			List<Customer> CustomerList=mapper.readValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/Customer.json"), new TypeReference<List<Customer>>() {});
			int stockIndex = StockUtility.searchSharesBySymbol(Symbol, CompanySharesList);
			System.out.println("Enter the person name");
			String Name = getString();
			int flag = StockUtility.searchPerson(Name, CustomerList);
			String stackSymbol = "";
			CompanyShares companyShares = null;
			if (flag== 1) {
				companyShares = CompanySharesList.get(stockIndex);
				int noOfShares = companyShares.getNo_OF_Shares();
				companyShares.setNo_OF_Shares(noOfShares + amount);

				System.out.println("");
				stackSymbol = companyShares.getShareSymbol();
				// ls.add(companyShares);

				// System.out.println(stockIndex);
				Customer customer = CustomerList.get(flag);
				if (stockIndex == 0) {
					int value = customer.getInfosysShares();
					customer.setInfosysShares(value - amount);
				}
				if (stockIndex == 1) {
					int value = customer.getGoogleShares();
					customer.setGoogleShares(value - amount);
				}
				if (stockIndex == 2) {
					int value = customer.getCapgeminiShares();
					customer.setCapgeminiShares(value - amount);
				}
			} else {
				System.err.println("stock not found!");
			}

			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/CompanyShares.json"), CompanySharesList);
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/Customer.json"), CustomerList);

			System.out.println("\n----------Stock Details----------");
			System.out.printf("%-15s %-20s %-20s\n", "Company Name", "NO. of Stocks", "Price");
			System.out.println("---------------------------------------------------------------------");
			System.out.println(CompanySharesList.get(stockIndex).toString());

			System.out.println("\n----------Customer Details----------");
			System.out.printf("\n%-15s %-20s %-20s %-20s\n", "Cust. Name", "Kapil(Shares)", "Swara(Shares)");
			System.out.println("----------------------------------------------------------------------");
			System.out.println(CustomerList.get(flag).toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void save(String FileName)
	{
		try {
			
			List<Customer> CustomerList=mapper.readValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/Customer.json"), new TypeReference<List<Customer>>() {});
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/Customer.json"), CustomerList);
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}
	public void PrintReport()
	{
		try {
			List<CompanyShares> CompanySharesList = mapper.readValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/CompanyShares.json"),
					new TypeReference<List<CompanyShares>>() {
					});
			List<Customer> customerList = mapper.readValue(new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/Customer.json"), new TypeReference<List<Customer>>() {
			});
			System.out.println("\n----------Stock Details----------");
			System.out.printf("%-15s %-20s %-20s\n", "Company-Name", "NO.of Stocks", "Price");
			System.out.println("--`1--------------------------------------------------------------");
			for (int i = 0; i < CompanySharesList.size(); i++) {

				System.out.println(CompanySharesList.get(i).toString());
			}

			System.out.println("\n----------Customer Details----------");
			System.out.printf("\n%-15s %-20s %-20s %-20s\n", "Cust. Name", "Infosys(Shares)", "Google(Shares)",
					"Capgemini(Shares)");
			System.out.println("----------------------------------------------------------------------");
			for (int i = 0; i < customerList.size(); i++) {
				System.out.println(customerList.get(i).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String getString()
	{
		String str;
		do 
		{
			str=scannerObject.nextLine();
		}while(Pattern.matches("[a-zA-Z]+", str));
		return str;
	}
	
	public static void main(String args[])
	{
		StockAccount stockObject=new StockAccount();
		stockObject.buy(20,"Infosys");
	}
	
}
