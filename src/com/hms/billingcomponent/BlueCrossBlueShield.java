package com.hms.billingcomponent;

public class BlueCrossBlueShield implements InsuranceBrand {

	private long id;
	private String name;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {

		double premium = 0 ;

		if(insurancePlan instanceof PlatinumPlan ) {
			premium = calculateInsuranceForAgeNSmoking(age,smoking,200,100);
		}
		else if (insurancePlan instanceof GoldPlan) {
			premium = calculateInsuranceForAgeNSmoking(age,smoking,150,90);
		}
		else if (insurancePlan instanceof SilverPlan) {
			premium = calculateInsuranceForAgeNSmoking(age,smoking,100,80);
		}
		else if (insurancePlan instanceof BronzePlan) {
			premium = calculateInsuranceForAgeNSmoking(age,smoking,50,70);
		}	
		else {
			premium = 0 ;
		}

		return premium;

	}

	private double calculateInsuranceForAgeNSmoking(int age, boolean smoking,double agePremium,
			double smokingPremium) {

		double val = 0;

		if(age<=55){
			if(smoking)
				val = smokingPremium;
			else
				val = 0;
		}
		else {
			if(smoking)
				val = smokingPremium+agePremium;
			else
				val = agePremium;
		}
		return val;
	}
}
