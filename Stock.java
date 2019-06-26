package com.bridgeit.ObjectOrintedPrograming;
import java.io.*;

import com.fasterxml.jackson.databind.JsonNode;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Stock {
	File openFile=new File("/home/admin123/eclipse-workspace/JavaPrograms/JsonFiles/StockList.json");
	ObjectMapper mapper=new ObjectMapper();
	String Stocks[]= {"","jewellery","Food"};
	int amount;
	Stock()
	{
		amount=0;
	}
	public  void getReport(int choice)
	{
		try
		{
			JsonNode node=mapper.readTree(openFile);
			JsonNode read=node.get(Stocks[choice]);
			for(JsonNode data:read)
			{
				System.out.print("Share Name : "+data.path("Name_Of_Share").asText());
				int no_of_shares=data.path("No_Of_Shares").asInt();
				int price_per_share=data.path("Price_Per_Share").asInt();
				System.out.println("\nNo of Shares : "+no_of_shares);
				System.out.println("Price per Share : "+price_per_share);
				System.out.println("Total Amount of Shares   : "+(no_of_shares*price_per_share)+"\n");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void getTotalShareValue()
	{
		try
		{
			JsonNode node=mapper.readTree(openFile);
			System.out.println("\n\n*** Total Stock Report ***");
			for(int i=1;i<Stocks.length;i++)
			{
				amount=0;
				JsonNode read=node.get(Stocks[i]);
				System.out.println("Stock Name : "+Stocks[i]);
				for(JsonNode data:read)
				{
					int no_of_shares=data.path("No_Of_Shares").asInt();
					int price_per_share=data.path("Price_Per_Share").asInt();
					amount+=(no_of_shares*price_per_share);
				}
				System.out.println("Total Amount of Shares   : "+amount);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
