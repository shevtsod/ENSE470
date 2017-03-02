package com.shevtsod.componentdecorators;

import com.shevtsod.Car;
import com.shevtsod.ComponentDecorator;

/**
 * @author Daniel Shevtsov
 */
public class WinterDec extends ComponentDecorator {
	private double price = 2500.00;
	
	public WinterDec(Car car) {
		super(car);
	}
	
	@Override
	public String getInformation() {
		return car.getInformation() + "\n + Winter Package";
	}
	
	@Override
	public double getPrice() {
		return car.getPrice() + price;
	}
}
