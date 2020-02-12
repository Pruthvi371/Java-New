package com.hms.billingcomponent;

public interface InsuranceBrand {
	public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking);
}