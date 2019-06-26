package com.bridgeit.ObjectOrintedPrograming.AddressBook;
import java.io.File;

import java.util.List;
import java.util.*;
public class PersonOperation extends FileOpearation {

				Scanner scannerString = new Scanner(System.in);
				Scanner scanner = new Scanner(System.in);
				private List<Person> newList = new ArrayList<Person>();
				CreatingFile fileSystem = new CreatingFile();
				static File file;
				private static String fileName;
			
				public PersonOperation() 
				{
					
				}
				public void createAddressBook() 
				{
					System.out.println("Enter File name ");
					String fileName = scannerString.next();
					System.out.println("Enter FileExtion");
					String fileExtion = scanner.next();
					if (fileExtion.equals(".json")||fileExtion.equals(".txt")) 
					{          //fileExtion == ".json" || fileExtion == ".txt") {
						@SuppressWarnings("static-access")
						File newFile = fileSystem.createNewFile(fileName.trim(), fileExtion);
						setFile(newFile);
						setFileName(fileName + fileExtion);
						CreatingFile.setList(newList);
						System.out.println("\nNew AddressBook Created!\n");
					} else {
					System.out.println("\nOnly .json and .txt files can be created!\n");
					}
				}
			
				public void openAddressBook() 
				{
					System.out.println("Enter File name");
					String fileName = scannerString.nextLine();
					System.out.println("Enter FileExtion");
					String fileExtion = scanner.next();
					if (fileExtion.equals(".json")||fileExtion.equals(".txt")) 
					{
						File openFile = FileOpearation.getPathOfFile(fileName, fileExtion);
						FileOpearation.readFile(openFile);
						setFile(openFile);
						setFileName(fileName + fileExtion);
					} else {
						System.out.println("\\n Only .json and .txt files can be created!\\n");
					}
				}
			
				public void addPerson(String firstName, String lastName, String address, String city, String state, String zip,
						String phone) {
					Person personnewEntry = new Person(firstName, lastName, address, city, state, zip, phone);
					newList = CreatingFile.getList();
					newList.add(personnewEntry);
					CreatingFile.setList(newList);
				}
			
				public void getFullOfPerson(String searchName) 
				{
					int index = searchPersonbyFirstName(searchName);
					if (index >= 0) {
						System.out.println(CreatingFile.getList().get(index).getFirstName() + " "
								+ CreatingFile.getList().get(index).getLastName());
					} else {
						System.out.println("Person Not Found");
					}
				}
				public void updatePerson(int index,String address,String city,String state,String zip,String phone)
				{
					fileSystem.getList().get(index).getAddress();
					fileSystem.getList().get(index).getCity();
					fileSystem.getList().get(index).getState();
					fileSystem.getList().get(index).getZip();
					fileSystem.getList().get(index).getPhone();
					System.out.println("Person info updated successfully ");
				}
				public void removePerson(int index)
				{
					fileSystem.getList().remove(index);
					
				}
				public void sortByPersonName()
				{
					newList=fileSystem.getList();
					ZIPComparator compareByperson= new ZIPComparator();
					Collections.sort(newList, compareByperson);
					
				}
				public void sortByzip()
				{
					newList=fileSystem.getList();
					ZIPComparator compareByZip= new ZIPComparator();
					Collections.sort(newList, compareByZip);
				}
				public void printAll()
				{
					newList = fileSystem.getList();
					for(Person p : newList)
					{
						System.out.println(p.toString());
					} 
				}
				
				// getters and Sterrs
			
				public List<Person> getPersonList()
				{
					return newList;
				}
			
				public void setPersonList(List<Person> personList) 
				{
					this.newList = personList;
				}
			
				public File getFile() 
				{
					return file;
				}
			
				public void setFile(File file) 
				{
					PersonOperation.file = file;
				}
			
				public int searchPersonbyFirstName(String keyFName) 
				{
					int index = -1;
					for (int i = 0; i <  com.bridgeit.ObjectOrintedPrograming.AddressBook.CreatingFile.getList().size(); i++) 
					{
						String personFirstName = com.bridgeit.ObjectOrintedPrograming.AddressBook.CreatingFile.getList().get(i).getFirstName();
						if (keyFName.equals(personFirstName)) 
						{
							index = i;
							break;
						}
					}
			
					return index;
				}
			
				public String getFileName() 
				{
					return fileName;
				}
			
				public void setFileName(String fileName) 
				{
					PersonOperation.fileName = fileName;
				}
			}
			//comparator classes implementing comparator interface
			class NameComparator implements Comparator<Person>
			{
			
				@Override
				public int compare(Person personOne, Person personTwo) 
				{
					return(personOne.getFirstName().compareTo(personTwo.getFirstName()));
				}
				
			}
			
			class ZIPComparator implements Comparator<Person>
			{
			
				@Override
				public int compare(Person personOne, Person personTwo) {
					
					int personOneZip = Integer.parseInt(personOne.getZip());
					int personTwoZip = Integer.parseInt(personTwo.getZip());
					if(personOneZip < personTwoZip)
					{
						return -1;
					}
					else if(personOneZip > personTwoZip)
					{
						return 1;
					}
					return 0;
				}
			}
			
