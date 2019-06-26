
package com.bridgeit.ObjectOrintedPrograming.AddressBook;
import java.util.Scanner;

public class AddressBookMain 
{
	static PersonOperation addressBook = new PersonOperation();// to implement all address book  methods 
	public static void addressMenu(boolean value)
	{
	Scanner sc=new Scanner(System.in);
	try {
		while(value)
		{
			System.out.println("Enter the choice:");
			System.out.println("1. Create New Address Book");
			System.out.println("2. Open existing Address Book");
			System.out.println("3. Add Person");
			System.out.println("4. Edit Person");
			System.out.println("5. Remove Person");
			System.out.println("6. Sort entries by name");
			System.out.println("7. Sort entries by zip");
			System.out.println("8. Print entries");
			System.out.println("9. Save Address Book");
			System.out.println("10.Save As Address Book");
			System.out.println("11.Quit Program");
			
			int n=sc.nextInt();
			switch(n)
			{
				case 1:	AddressBookManager.addnewBook();
						break;
						
				case 2: AddressBookManager.openBook();						
						break;
					
				case 3: AddressBookManager.addPersonToBook();
						break;
						
				case 4:	AddressBookManager.updatePersonOfBook();
						break;						
						
				case 5: AddressBookManager.removePersonFromBook();
						break;
					
				case 6:	AddressBookManager.sortByName();
						break;
						
				case 7: AddressBookManager.sortByzipCode();;
						break;
					
				case 8: AddressBookManager.printBookDetails();
						break;
					
				case 9: AddressBookManager.saveBook();
						break;
						
				case 10: AddressBookManager.saveAs();		
						break;
						
				case 11: System.out.println("\nApplication stopped!\n"); 
						value = false;
						break;
						
						
				default: System.out.println("invalid choice... try again");
						
			}	
		}	
	}
	catch(NullPointerException e)
	{
		System.out.println("\nNo AddressBook opened currently!");
	}
	
}

}


