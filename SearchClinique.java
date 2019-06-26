package com.bridgeit.ObjectOrintedPrograming;
import java.util.*;
public class SearchClinique {
		int check=0;
		public boolean doctorByName(String name,List<Doctor> DoctorList)
		{
			for(int i=0;i<DoctorList.size();i++)
			{
				String doctorName=DoctorList.get(i).getName();
				if(doctorName.equals(name))
				{
					System.out.println("Doctor Found");
					System.out.printf("\n%-15s%-10s%-15s%-15s\n","Name","Id","Specialization","Availability");
					System.out.println(DoctorList.get(i).toString());
				}
				else
				{
					check++;
				}
			}
			if(check==0)
			{
				System.out.println("Sorry , Doctor not found");
				return false;
			}
			return true;
		}
		public void doctorById(int id,List<Doctor> DoctorList)
		{
			check=0;
			for(int i=0;i<DoctorList.size();i++)
			{
				int Id=DoctorList.get(i).getId();
				if(Id==id)
				{
					System.out.println("Doctor Found");
					System.out.printf("\n%-15s%-10s%-15s%-15s\n","Name","Id","Specialization","Availability");
					System.out.println(DoctorList.get(i).toString());
				}
				else
				{
					check++;
				}
			}
			if(check==0)
			{
				System.out.println("Sorry , Doctor not Found");
			}
		}
		public void  doctorBySpeciality(String speciality,List<Doctor> DoctorList)
		{
			check=0;
			for(int i=0;i<DoctorList.size();i++)
			{
				String Speciality=DoctorList.get(i).getSpecialization();
				if(Speciality.equals(speciality))
				{
					System.out.println("Doctor Found");
					System.out.printf("\n%-15s%-10s%-15s%-15s\n","Name","Id","Specialization","Availability");
					System.out.println(DoctorList.get(i).toString());
				}
				else
				{
					check++;
				}
			}
			if(check==0)
			{
				System.out.println("Sorry , Doctor not Found");
			}
			
		}
		public void doctorByAvailability(String available,List<Doctor> DoctorList)
		{
			check=0;
			for(int i=0;i<DoctorList.size();i++)
			{
				String Availability=DoctorList.get(i).getAvailability();
				if(Availability.equals(available))
				{
					System.out.println("Doctor Found");
					System.out.printf("\n%-15s%-10s%-15s%-15s\n","Name","Id","Specialization","Availability");
					System.out.println(DoctorList.get(i).toString());
				}
				else
				{
					check++;
				}
			}
			if(check==0)
			{
				System.out.println("Sorry , Doctor not Found");
			}
		}
		public boolean patientByName(String name,List<Patient> PatientList)
		{
			check=0;
			for(int i=0;i<PatientList.size();i++)
			{
				String Name=PatientList.get(i).getName();
				if(Name.equals(name))
				{
					System.out.println("Patient Found");
					System.out.printf("\n%-15s%-15s%-15s%-15s\n","Name","Id","Specialization","Availability");
					System.out.println(PatientList.get(i).toString());
				}
				else
				{
					check++;
				}
			}
			if(check==0)
			{
				System.out.println("Sorry , Patient not Found");
				return false;
			}
			return true;
		}
		public void patientById(int id,List<Patient> PatientList)
		{
			check=0;
			for(int i=0;i<PatientList.size();i++)
			{
				int Id=PatientList.get(i).getId();
				if(Id==id)
				{
					System.out.println("Patient Found");
					System.out.printf("\n%-15s%-10s%-15s%-15s\n","Name","Id","Specialization","Availability");
					System.out.println(PatientList.get(i).toString());
				}
				else
				{
					check++;
				}
			}
			if(check==0)
			{
				System.out.println("Sorry , Patient not Found");
			}
		}
		public void patientByMobileNumber(String mobilenumber,List<Patient> PatientList)
		{
			check=0;
			for(int i=0;i<PatientList.size();i++)
			{
				String MobileNumber=PatientList.get(i).getMobileNumber();
				if(MobileNumber.equals(mobilenumber))
				{
					System.out.println("Patient Found");
					System.out.printf("\n%-15s%-10s%-15s%-15s\n","Name","Id","Specialization","Availability");
					System.out.println(PatientList.get(i).toString());
				}
				else
				{
					check++;
				}
			}
			if(check==0)
			{
				System.out.println("Sorry , Patient not Found");
			}
		}
		public int getAppointedDocIndex(String searchName, List<Appointment> appointmentList)
		{
			int index = -1;
			for(int i = appointmentList.size()-1; i >= 0; i--)
			{
				String docName = appointmentList.get(i).getDoctorName();
				if(searchName.compareTo(docName) == 0)
				{
					index = i;
					break;
				}

			}
			
			return index;
		}
	


}
