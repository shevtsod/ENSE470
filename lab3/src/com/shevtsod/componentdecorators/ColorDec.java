package com.shevtsod.componentdecorators;

import com.shevtsod.Car;
import com.shevtsod.ComponentDecorator;

/**
 * @author Daniel Shevtsov
 */
public class ColorDec extends ComponentDecorator {
	private double price = 150.00;

	public ColorDec(Car car) {
		super(car);
	}
	
	@Override
	public String getInformation() {
		return car.getInformation() + "\n + Custom Color Option";
	}
	
	@Override
	public double getPrice() {
		return car.getPrice() + price;
	}
}
