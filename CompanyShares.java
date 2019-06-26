package com.bridgeit.ObjectOrintedPrograming;

public class CompanyShares {
		private String CompanyName;
		private String ShareSymbol;
		private int No_OF_Shares;
		private int Price;
		private String Daytime;
		CompanyShares()
		{
			CompanyName=ShareSymbol=Daytime="";
			No_OF_Shares=Price=0;
		}
		CompanyShares(String CompanyName,String ShareSymbol,int No_Of_Shares,int Price,String Daytime)
		{
			this.CompanyName=CompanyName;
			this.ShareSymbol=ShareSymbol;
			this.No_OF_Shares=No_Of_Shares;
			this.Price=Price;
			this.Daytime=Daytime;
		}
		
		/*
		 * @purpose : Creating getter and setter methods
		 */
		public void setCompanyName(String CompanyName)
		{
			this.CompanyName=CompanyName;
		}
		public String getCompanyName()
		{
			return CompanyName;
		}
		public void setShareSymbol(String Symbol)
		{
			this.ShareSymbol=Symbol;
		}
		public String getShareSymbol()
		{
			return ShareSymbol;
		}
		public void setNo_OF_Shares(int Shares)
		{
			this.No_OF_Shares=Shares;
		}
		public int getNo_OF_Shares()
		{
			return No_OF_Shares;
		}
		public  void setPrice(int Price)
		{
			this.Price=Price;
		}
		public int getPrice()
		{
			return Price;
		}
		public void setDaytime(String time)
		{
			this.Daytime=time;
		}
		public String getDaytime()
		{
			return Daytime;
		}
}
