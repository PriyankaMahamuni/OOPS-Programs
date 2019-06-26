/**
 * @purpose 	: Clinique Management Programme.
 * @author 		: Priynka Mahamuni
 * @version 	: 1.0
 * @since 		: 07.06.19
 */
package com.bridgeit.ObjectOrintedPrograming;
import java.io.File;

import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class CliniqueMaster {
		static ObjectMapper mapper=new ObjectMapper() ;
		static int choice;
		static char ch;
		public static void main(String []args)
		{
			/*
			 * @purpose : to create list from json string
			 */
			Doctor doctor=new Doctor();
			Patient patient=new Patient();
			Scanner scanner=new Scanner(System.in);
			try {
				List<Doctor> DoctorList=mapper.readValue(new File("/home/admin1/Documents/Task/JsonFiles/Doctor.json"), new TypeReference<List<Doctor>>() {});
				List<Patient> PatientList=mapper.readValue(new File("/home/admin1/Documents/Task/JsonFiles/Patient.json"), new TypeReference<List<Patient>>() {});
				List<Appointment> AppointmentList=mapper.readValue(new File("/home/admin1/Documents/Task/JsonFiles/Appointment.json"), new TypeReference<List<Appointment>>() {});
				do{
					System.out.println("Menu\nA.ADD\n\t1. Doctor\n\t2. Patient\n"
										   + "B.Display\n\t3. Doctors\n\t4. Patients\n"
										   + "C.Search\n\t5. Doctor\n\t6. Patinets\n"
										   + "D.Appontment\n\t7. New Appointment\n"
										   + "E.Report\n\t8. Popular Doctor\n\t9. Clinique Speciality");
					System.out.println("Enter Your Choice");
					choice=scanner.nextInt();
					switch(choice)
					{
						case 1:CliniqueUtility.addDoctor(DoctorList);
							   break;
						case 2:CliniqueUtility.addPatient(PatientList);
						       break;
						case 3:
								for(int i=0;i<DoctorList.size();i++)
								{
									System.out.println("Name         : "+DoctorList.get(i).getName());
									System.out.println("Id	         : "+DoctorList.get(i).getId());
									System.out.println("Speciality   : "+DoctorList.get(i).getSpecialization());
									System.out.println("Availability : "+DoctorList.get(i).getAvailability());
								}
								
							   break;
						case 4:
								for(int i=0;i<PatientList.size();i++)
								{
									System.out.println("Name 		: "+PatientList.get(i).getName()+"\t\t");
									System.out.println("Id   		:"+PatientList.get(i).getId()+"\t");
									System.out.println("Mobile No.	:"+PatientList.get(i).getMobileNumber());
									System.out.println("Age			:"+PatientList.get(i).getAge());
								}
								
							   break;
						case 5:CliniqueUtility.searchDoctor(DoctorList);
						       break;
						case 6:CliniqueUtility.searchPatient(PatientList);
						       break;
						case 7:CliniqueUtility.newAppointment(DoctorList,PatientList);
						       break;
						case 8:CliniqueUtility.PopularDoctor(DoctorList);
						       break;
						case 9:CliniqueUtility.Speciality(DoctorList);
						       break;
						case 10:
							   break;
						default:System.out.println("Invalid Choice");
						        break;
					}
					System.out.println("\nDo you want another operation ?(y/n) :  ");
					ch=scanner.next().charAt(0);
					
				}while(ch=='y'||ch=='Y');
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		

	

}
