package com.bridgeit.ObjectOrintedPrograming;
import java.util.*;
public class StockUtility {
	
	public static void addAccount(String FileName)
	{
		
	}
	public static int searchPerson(String person,List<Customer> CustomerList)
	{
		int count=0;
		for(int i=0;i<CustomerList.size();i++)
		{
			String name=CustomerList.get(i).getName();
			if(name.compareTo(person)==0)
			{
				System.out.println("Customer Found");
				count=i;
			}
			else {
				count++;
			}
		}
		return count;
	}
	public static int searchSharesBySymbol(String Symbol,List<CompanyShares> CompanySharesList)
	{
		int count=0;
		for(int i=0;i<CompanySharesList.size();i++)
		{
			String symbol=CompanySharesList.get(i).getShareSymbol();
			if(symbol.compareTo(Symbol)==0)
			{
				System.out.println("Symbol of company is found");
				count=i;
			}
			else
			{
				count++;
			}
		}
		return count;
	}
}
