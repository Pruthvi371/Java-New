package com.hms.billingcomponent;

public class SilverPlan extends HealthInsurancePlan {

	public SilverPlan() {
		coverage = .7 ;
	}

	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		return 0.08 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}
}
