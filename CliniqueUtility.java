
package com.bridgeit.ObjectOrintedPrograming;

import java.io.*;

import java.util.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class CliniqueUtility {
		static ObjectMapper mapper=new ObjectMapper();
		static Scanner scanner=new Scanner(System.in);
		static Scanner scannerString=new Scanner(System.in);
		public static  void addDoctor(List<Doctor> DoctorData)
		{
			System.out.println("Enter Doctor Details");
			System.out.print("Name			: ");
			String Name=CliniqueUtility.getString();
			System.out.print("\nId			: ");	
			int Id=scanner.nextInt();
			System.out.print("\nSpeciality  : ");
			String speciality=CliniqueUtility.getString();
			System.out.print("\nAvailability  : ");
			String availability=CliniqueUtility.getString();
			Doctor newDoctor=new Doctor(Name,Id,speciality,availability);
			DoctorData.add(newDoctor);
			try {
				mapper.writeValue(new File("/home/admin1/Documents/Task/JsonFiles/Doctor.json"), DoctorData);
				System.out.println("New Doctor is added to Clinique");
				System.out.printf("\n%-15s%-10s%-20s%-15s\n",Name,Id,speciality,availability);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public static void addPatient(List<Patient> PatientData)
		{
			System.out.println("Enter patient Details");
			System.out.print("Name				: ");
			String name=CliniqueUtility.getString();
			System.out.print("\nMobileNumber	: ");
			String mobilenumber=CliniqueUtility.getString();
			System.out.print("\nId				: ");
			int id=scanner.nextInt();
			System.out.print("\nAge             : ");
			int age=scanner.nextInt();
			Patient newPatient=new Patient(name,mobilenumber,id,age);
			PatientData.add(newPatient);
			try {
				mapper.writeValue(new File("/home/admin1/Documents/Task/JsonFiles/Patient.json"), PatientData);
				System.out.printf("\n%-15s%-10s%-15s%-15s\n",name,mobilenumber,id,age);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public static void searchDoctor(List<Doctor> DoctorList) {
			SearchClinique search=new SearchClinique();
			System.out.println("Menu\n1. By Name\n2. By ID\n3. By Speciality\n4. By Availability\n5. Exit");
			System.out.print("Enter your Choice : ");
			int choice=scanner.nextInt();
			switch(choice)
			{
				case 1: System.out.print("\nEnter Name of Doctor for search : ");
				        String name=CliniqueUtility.getString();
				        search.doctorByName(name,DoctorList);
				        break;
				case 2: System.out.print("\nEnter Id of Doctor for search   : ");
				        int id=scanner.nextInt();
				        search.doctorById(id,DoctorList);
				        break;
			    case 3: System.out.print("\nEnter Speciality of Doctor for search	: ");
			            String speciality=CliniqueUtility.getString();
			            search.doctorBySpeciality(speciality,DoctorList);
			            break;
			    case 4: System.out.print("\nEnter Availability of Doctor for search : ");
			            String available=CliniqueUtility.getString();
			            search.doctorByAvailability(available,DoctorList);
			            break;
			   case 5:  System.out.println("Thanks for visiting our Clinique !!");
			    		break;
			   default: System.out.println("Invalid Choice");
			            break;
			}
		}
		public static void searchPatient(List<Patient> PatientList)
		{
			SearchClinique search=new SearchClinique();
			System.out.println("Menu\n1. By Name\n2. By ID\n3. By Mobile Number\n4. Exit");
			System.out.print("Enter your Choice : ");
			int choice=scanner.nextInt();
			switch(choice)
			{
				case 1: System.out.print("\nEnter Name of Patient for search : ");
				        String name=CliniqueUtility.getString();
				        search.patientByName(name,PatientList);
				        break;
				case 2: System.out.print("\nEnter Id of Patient for search   : ");
				        int id=scanner.nextInt();
				        search.patientById(id,PatientList);
				        break;
			    case 3: System.out.print("\nEnter Mobile Number of Patient for search	: ");
			            String mobilenumber=CliniqueUtility.getString();
			            search.patientByMobileNumber(mobilenumber,PatientList);
			            break;
			   case 4:  System.out.println("Thank You  for visiting our Clinique !!");
			    		break;
			   default: System.out.println("Invalid Choice");
			            break;
			}

		}
		public static void newAppointment(List<Doctor> DoctorList,List<Patient> PatientList)
		{
			String appointmentFile = "/home/admin1/Documents/Task/JsonFiles/Appointment.json";
			try {
				List<Appointment> appointmentList = mapper.readValue(new File(appointmentFile),
						new TypeReference<List<Appointment>>() {
						});

				SearchClinique searchStart = new SearchClinique();
				System.out.println("Enter the Doctor's name:");
				String doctorName = scanner.nextLine().toUpperCase();
				if (searchStart.doctorByName(doctorName, DoctorList) == true) {
					System.out.println("Enter the patient's name:");
					String patientName = scanner.nextLine().toUpperCase();
					if (searchStart.patientByName(patientName, PatientList) == true) {
						System.out.println("Enter the date(DD/MM/YYYY): ");
						String date = scanner.nextLine();
						int index = searchStart.getAppointedDocIndex(doctorName, appointmentList);
						int docCount;

						// System.out.println(index);
						if (index == -1) {
							docCount = 1;
						} else {
							docCount = appointmentList.get(index).getCount();
							docCount = docCount + 1;
						}
										}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		public static void PopularDoctor(List<Doctor> DoctorList)
		{
			if(DoctorList.isEmpty())
			{
				System.out.println("Doctor is not present\n");
			}
			else
			{
				System.out.println("Popular Doctor in clinique  is "
						+ DoctorList.get(0).getName() + "\n");
			}

		}
		public static void Speciality(List<Doctor> DoctorList)
		{
			if(DoctorList.isEmpty())
			{
				System.out.println("Doctors are not available at this time\n");
			}
			else
			{
				System.out.println("Popular Specialization is "
						+DoctorList.get(0).getSpecialization() + "\n");
			}

		}
	    public static String getString() {
	    	String str=scannerString.nextLine();
	    	return str;
	    }
	
}
