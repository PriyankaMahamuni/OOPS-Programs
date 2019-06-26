package com.bridgeit.ObjectOrintedPrograming;

public interface StockInfo {
	public void StockAccount(String FileName);
	public double valueOf();
	public void buy(int amount,String Symbol);
	public void sell(int amount,String Symbol);
	public void save(String FileName);
	public void PrintReport();
}
