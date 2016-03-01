package Q2MainPackage;

import java.util.Scanner;
/**Joaquin Martinez CISC181 Quiz2**/
public class Main {
public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		
		System.out.print("What is the Initial Tuition Cost?: ");
		final double iniTuition=in.nextDouble();
		
		System.out.print("what is the repayment APR for the loan?: ");
		final double APR=in.nextDouble();
		
		System.out.print("How Many Years of Repayment are Scheduled?: ");
		final long schedule=in.nextLong();
		
		double[] perRates=new double[3];
		for (int i=2; i<5; i++)
		{
			System.out.print("Enter the Percentage Increase for Year-" + i + ": ");
			double incdRate=in.nextDouble();
			perRates[i-2]=incdRate;
		}
		
		in.close();
		
		String totaltuition =String.format("%.2f", totalTuition(iniTuition, perRates));
		System.out.println("The Total Cost of Tuition is $" + totaltuition);
		
		double monthlypay= monPay(totalPay(iniTuition, perRates, APR), schedule);
		String finalmonPay = String.format("%.2f", monthlypay);
		System.out.println("Monthly Payment is $" + finalmonPay);
		
	}
	
	public static double totalTuition(double val, double[] rates)
	{
		double cost=val;
		double total= val;
		for (int i=0; i<3; i++)
		{
			cost=cost*(1 + (rates[i] / 100));
			total +=cost;
		}
		return total;
	}
	public static double monPay(double total, long year)
	{
		return (total/(12*year));
	}
	public static double totalPay(double val, double[] rates, double apr)
	{
		double cost= val;
		double total= val;
		for (int i=0; i<3; i++)
		{
			total= total* (1 +(apr/100));
			cost=cost * (1 +(rates[i]/100));
			total+= cost;
		}
		return total;
	}
	
	
}
