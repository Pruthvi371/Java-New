package com.hms.billingcomponent;

public class PlatinumPlan extends HealthInsurancePlan {

	public PlatinumPlan() {
		coverage = .9;
	}

	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		return 0.08 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}

}
