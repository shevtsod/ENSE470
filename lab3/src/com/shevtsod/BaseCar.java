package com.shevtsod;

/**
 * @author Daniel Shevtsov
 */
public class BaseCar implements Car {
	
	private double price = 20000.00;

	@Override
	public String getInformation() {
		return "Base Vehicle";
	}

	@Override
	public double getPrice() {
		return price;
	}
	
}
