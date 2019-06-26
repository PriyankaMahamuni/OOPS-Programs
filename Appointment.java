package com.bridgeit.ObjectOrintedPrograming;

public class Appointment {
				String DoctorName,PatientName,dayDate;
				int Count;
				public void setDoctorName(String Name)
				{
					this.DoctorName=Name;
				}
				public String getDoctorName()
				{
					return DoctorName;
				}
				public void setPatientName(String Name)
				{
					this.PatientName=Name;
				}
				public String getPatientName()
				{
					return PatientName;
				}public void setDate(String Date)
				{
					this.dayDate=Date;
				}
				public String getDate()
				{
					return dayDate;
				}
				public void  setCount(int count)
				{
					this.Count=count;
				}
				public int getCount()
				{
					return Count;
				}
}

