package brd.emiCalculator;

/**

 *@Class Emi_Calculator
 * @version 3.0 23.11.2018 
 * @author Lakshmi Narayanan
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EMICalculator
{
	public static List<String> recordStorage = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	static float emiInitializer = (float) 0.0;
	static boolean emiCalculatorFlag = true;

	public static void main(String[] args)
	{
		EMICalculator EmiRecordTable = new EMICalculator();
		EmiRecordTable.calulation();
		System.out.println("Enter the installentation number");
		int i = scanner.nextInt();
		System.out.println(recordStorage.get(i));
	}

	public void calulation()
	{
		System.out.println("Welcome To Banking");
		System.out.println("Enter the LoanAmount");
		float principle = scanner.nextFloat();
		System.out.println("Enter the RateofInterst");
		float RateofInterest = scanner.nextFloat();
		RateofInterest = (RateofInterest / 100);
		float tenure = 0;
		try
		{
			System.out.println("Enter the Tenure_or_number_of_installments");
			tenure = scanner.nextFloat();
			if (tenure <= 0)
			{
				throw new InputMismatchException("Negative number");
			}
		} catch (InputMismatchException inputMismatchException)
		{
			System.out.println(inputMismatchException.getMessage());
			while (tenure < 0)
			{

				System.out.println("Enter the correct positive tenure");
				tenure = scanner.nextFloat();
			}
		}

		float Number_of_installenment_in_a_year = 0;
		try
		{
			System.out.println("Enter the no of payment in a year (constant value)");
			Number_of_installenment_in_a_year = scanner.nextFloat();
			if (Number_of_installenment_in_a_year > tenure)
			{
				throw new InputMismatchException("The installenement vlaue should be greater than the tenure");
			}
		} catch (InputMismatchException inputMismatchException)
		{
			System.out.println(inputMismatchException.getMessage());
			while (Number_of_installenment_in_a_year > tenure)
			{
				System.out.println("Enter the correct instalenment number");
				Number_of_installenment_in_a_year = scanner.nextFloat();
			}
		}
		// function2  Repayment Schedule for the entire loan period 
		for (int i1 = 0; i1 < 12; i1++)
		{
			System.out.println(i1);
			principle = calculateInstallment(principle, RateofInterest, tenure,
					Number_of_installenment_in_a_year);
		}
	}


	float calculateInstallment(float principle, float RateofInterest, float Tenure_or_number_of_installments,
			float Number_of_payments_in_a_year)
	{
		float numerator1 = (RateofInterest / Number_of_payments_in_a_year);
		float numerator = (principle * numerator1);

		float denominator_1 = 1 + numerator1;

		float denominator_2 = (float) (Math.pow(denominator_1, Tenure_or_number_of_installments));

		float denominator = (1 - (1 / denominator_2));
		if (emiCalculatorFlag)
		{
			emiInitializer = (numerator / denominator);
			emiCalculatorFlag = false;
		}

		double Pn = (emiInitializer - numerator);
		double OPn = (principle - Pn);

		DecimalFormat formatter = new DecimalFormat("#.##");
		System.out.format("%-15s %-25s %-15s %-15s\n", "O/s Principle", "Interest", "Principle", "EMI");
		System.out.format("%-15s %-25s %-15s %-15s\n", formatter.format(principle), formatter.format(numerator),
				formatter.format(Pn), formatter.format(emiInitializer));
		String v = ("laonAm: " + formatter.format(principle) + " Interest:" + formatter.format(numerator)
				+ " Principle :" + formatter.format(Pn) + " EMI:" + formatter.format(emiInitializer));
		recordStorage.add(v);
		return (float) OPn;
	}
}
