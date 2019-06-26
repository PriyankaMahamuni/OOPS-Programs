/**
 * @purpose  	: To Create the JSON from Inventory Object and output the JSON String.
 * @author 		: Priyanka Mahamuni
 * @version 	: 1.0
 * @since 		: 04.05.19
 */

package com.bridgeit.ObjectOrintedPrograming;

import java.io.File;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InventoryManagement {
 
	public static void main(String[] args) {
		//Creating Scanner class object
		Scanner scanner = new Scanner(System.in);
		//Opening File
		File openFile = new File("/home/admin1/Documents/Task/JsonFiles/inventory.json");
		//it maps Json objects into java Objects
		ObjectMapper mapper = new ObjectMapper();
		String inventories[]= {"","Rice","Pulses","Wheat"};//total inventories in file
		int Choice;
		try 
		{
			
			JsonNode fileRead = mapper.readTree(openFile);
			System.out.println(" 1:Rice" + "\n 2:Pulses" + "\n 3:Wheat");
		    System.out.println("Enter Product  number");
		    Choice = scanner.nextInt();
			
			if(!(Choice>3))
			{
				JsonNode inventory = fileRead.get(inventories[Choice]);				
				for (JsonNode data : inventory)
				{		
					String name = data.path("Name").asText();
					int price = data.path("Price").asInt();
					int weight = data.path("Weight").asInt();
	
					System.out.println("Name:" + name + "\nPrice: " + price + "\nWeight: " + weight);
					System.out.println("Total Price : " + price * weight + " Rs" + "\n");
				}
			}
			else
			{
				System.out.println("Invalid Choice");
			}
		
		}
		catch (IOException |InputMismatchException e)
		{		
			e.printStackTrace();
			System.err.println("Please Give Valid File Details");
	    }
		scanner.close();
	}

}
	