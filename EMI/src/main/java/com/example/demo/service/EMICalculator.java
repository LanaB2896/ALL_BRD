package com.example.demo.service;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Calculator;
import com.example.demo.repo.ClientRepository;


public class EMICalculator {
	@Autowired
private ClientRepository clientepo;
	static float emiInitializer = (float) 0.0;
	static boolean emiCalculatorFlag = true;

	float principle;
	float RateofInterest;
	float Tenure_or_number_of_installments;
	float Number_of_payments_in_a_year;

	public EMICalculator(float principle, float rateofInterest, float tenure_or_number_of_installments,
			float number_of_payments_in_a_year) {
		super();
		this.principle = principle;
		RateofInterest = rateofInterest;
		Tenure_or_number_of_installments = tenure_or_number_of_installments;
		Number_of_payments_in_a_year = number_of_payments_in_a_year;
		
		for (int i = 1; i <= Number_of_payments_in_a_year; i++)
		{
			System.out.println(i);
			principle = calculateInstallment(principle, RateofInterest, Tenure_or_number_of_installments,
					Number_of_payments_in_a_year);
		}
	}




	float calculateInstallment(float principle, float RateofInterest, float Tenure_or_number_of_installments,
			float Number_of_payments_in_a_year) {
		float numerator1 = ((RateofInterest/100) / Number_of_payments_in_a_year);
		float numerator = (principle * numerator1);

		float denominator_1 = 1 + numerator1;

		float denominator_2 = (float) (Math.pow(denominator_1, Tenure_or_number_of_installments));

		float denominator = (1 - (1 / denominator_2));
		if (emiCalculatorFlag) {
			emiInitializer = (numerator / denominator);
			emiCalculatorFlag = false;
		}

		double Pn = (emiInitializer - numerator);
		double OPn = (principle - Pn);
		DecimalFormat formatter = new DecimalFormat("#.##");
		
Calculator calculator = new Calculator();
Float outstandingPrinciple = Float.parseFloat(formatter.format(principle));
Float interest = Float.parseFloat(formatter.format(numerator));
Float loanAmount = Float.parseFloat(formatter.format(Pn));
Float EMI = Float.parseFloat(formatter.format(emiInitializer));



calculator.setOutstandingPrinciple(outstandingPrinciple);
calculator.setInterest(interest);
calculator.setLoanAmount(loanAmount);
calculator.setEMI(EMI);
clientepo.save(calculator);
	

		System.out.format("%-15s %-25s %-15s %-15s\n", "O/s Principle", "Interest", "Principle", "EMI");
		System.out.format("%-15s %-25s %-15s %-15s\n", formatter.format(principle), formatter.format(numerator),
				formatter.format(Pn), formatter.format(emiInitializer));

		return (float) OPn;
	}
}

