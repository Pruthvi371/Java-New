package com.hms.billingcomponent;

import com.hospitalmanagementsystem.Patient;

public class Billing {
	   
    public static double[] computePaymentAmount(Patient patient, double amount) {
        double[] payments = new double[2];
        
        HealthInsurancePlan patientInsurancePlan = patient.getInsurancePlan();

        if(patientInsurancePlan != null) {
        	
        	payments[0] = amount*patientInsurancePlan.getCoverage();
        	
        	System.out.println("adas" + patientInsurancePlan.getCoverage());
        	
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

}
