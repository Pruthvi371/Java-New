package com.hms.billingcomponent;

public class GoldPlan extends HealthInsurancePlan {

	public GoldPlan() {
		coverage = .8;
	}

	public double computeMonthlyPremium(double salary, int age, boolean smoking) {
		return 0.08 * salary + getOfferedBy().computeMonthlyPremium(this, age, smoking);
	}

}
