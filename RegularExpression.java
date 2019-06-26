/**
 * @purpose replacing name,full name,mobile number and date in json file
 * @author Priynka Mahamuni
 * @version 
 * @since 17.05.19
 */
package com.bridgeit.ObjectOrintedPrograming;
import java.util.*;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.text.SimpleDateFormat;
public class RegularExpression {
	
	public static String getString()
	{
		Scanner scanner=new Scanner(System.in);
		String string="";
		do
		{
			System.out.println("Enter : ");
			string=scanner.next();
		
		}while(Pattern.matches("[a-zA-Z]+", string));//check pattern
		return string;
	}
	public static String getNumber()
	{
		Scanner scanner=new Scanner(System.in);
		String mobileNumber="";
		do
		{
			System.out.println("Enter Mobile Number : ");
			mobileNumber=scanner.next();
		}while(Pattern.matches("[789][0-9]{9}", mobileNumber));//check pattern 
		return mobileNumber;
	}
	public static void replaceString(String regularExpression)
	{
		System.out.println("Please enter your Name");
		String name=getString();//getting name from user
		//it will replace <<name>> in file with given name
		regularExpression=regularExpression.replaceAll("<<name>>", name);
		
		System.out.println("Please enter your full Name");
		String fullName=getString();//getting full name from user
		//it will replace <<full name>> in file with given name 
		regularExpression=regularExpression.replaceAll("<<full name>>", fullName);
		
		String mobileNumber=getNumber();//getting mobile number from user
		regularExpression=regularExpression.replaceAll("xxxxxxxxxx",mobileNumber);
		
		//getting todays date using SimpleDateFormat class and format function
		Date todayDate=new Date();
		SimpleDateFormat format=new SimpleDateFormat();
		String todaysDate=format.format(todayDate);
		regularExpression=regularExpression.replaceAll("01/01/2016", todaysDate);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File openFile=new File("/home/admin1/Documents/Task/JsonFiles/RegularExpression.json");
		try
		{
			ObjectMapper mapper=new ObjectMapper();
			JsonNode node=mapper.readTree(openFile);
			JsonNode expression=node.get("Expression");
			String regularExpression=expression.asText();
			replaceString(regularExpression);
			System.out.println(regularExpression);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
