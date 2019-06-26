/**
 * @purpose 	: Print the Stock Report.
 * @author 		: Priynka Mahamuni
 * @version 	: 1.0
 * @since 		: 08.06.19
 */
package com.bridgeit.ObjectOrintedPrograming;
import java.util.*;
public class StockPortFolio {
		public static void main(String s[])
		{
			Scanner scanner=new Scanner(System.in);
			System.out.println("Menu\n1.jewellery\n2.Food");
			System.out.println("Enter Stock Number");
			int choice=scanner.nextInt();
			Stock obj=new Stock();
			obj.getReport(choice);
			obj.getTotalShareValue();
		}
		
}
