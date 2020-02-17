package com.hms.billingcomponent;

import com.hospitalmanagementsystem.Patient;
import com.hospitalmanagementsystem.User;

public class Billing {

	public static double[] computePaymentAmount(Patient patient, double amount) {
		double[] payments = new double[2];

		HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

		payments = calculateBillBasedOnInsuranceInstances(patientInsurancePlan , payments , amount);

		return payments;
	}

	private static double[] calculateBillBasedOnInsuranceInstances(HealthInsurancePlan patientInsurancePlan,
			double[] payments, double amount) {

		if(patientInsurancePlan != null) {

			payments[0] = amount*patientInsurancePlan.coverage;

			if(patientInsurancePlan instanceof PlatinumPlan ) {
				payments[1] = (amount-payments[0])-50 ;
			}
			else if (patientInsurancePlan instanceof GoldPlan) {
				payments[1] = (amount-payments[0])-40 ;
			}
			else if (patientInsurancePlan instanceof SilverPlan) {
				payments[1] = (amount-payments[0])-30 ;
			}
			else if (patientInsurancePlan instanceof BronzePlan) {
				payments[1] = (amount-payments[0])-25 ;
			}	
			else 
				payments[1]= amount-20 ;
		}

		else
			payments[0] = 0.0;

		return payments;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, Exception {

		HealthInsurancePlan insurancePlan = new PlatinumPlan();
		Patient patient = new Patient();
		patient.setInsurancePlan(insurancePlan);
		double [] payments = computePaymentAmount(patient, 1000);

		System.out.println("Amount need to paid by Insurance company "+payments[0]
				+" and the patient has to pay "+payments[1]);


		User staff = new User();
		InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
		HealthInsurancePlan insurancePlan1 = new PlatinumPlan();
		insurancePlan1.setOfferedBy(insuranceBrand);
		staff.setInsurancePlan(insurancePlan1);
		System.out.println("Premium Amount Of Staff is "+((PlatinumPlan) insurancePlan1).computeMonthlyPremium(5000,56,true));
	
	}

}
