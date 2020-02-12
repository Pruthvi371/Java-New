package com.hms.billingcomponent;

public class BronzePlan extends HealthInsurancePlan{

	public BronzePlan() {
		coverage = .6 ;
	}

	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		return 0.08 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
