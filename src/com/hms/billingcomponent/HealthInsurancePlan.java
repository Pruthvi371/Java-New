package com.hms.billingcomponent;

public class HealthInsurancePlan {

	public double coverage ;
	private InsuranceBrand offeredBy;


	public double getCoverage() {
		return coverage;
	}
	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}
	public InsuranceBrand getOfferedBy() {
		return offeredBy;
	}
	public void setOfferedBy(InsuranceBrand offeredBy) {
		this.offeredBy = offeredBy;
	}




}