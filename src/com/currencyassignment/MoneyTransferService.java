package com.currencyassignment;

public class MoneyTransferService {

	CurrencyConverter cc = new CurrencyConverter();
	
	public double computeTransferAmount(int countryIndex, double amount) {

		return cc.computeTransferAmount(countryIndex, amount);
	}

	public double computeTransferFee(int countryIndex, double amount) {

		return (computeTransferAmount(countryIndex, amount)*.02);
	}

}
