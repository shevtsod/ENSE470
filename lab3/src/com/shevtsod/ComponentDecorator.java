package com.shevtsod;

/**
 * @author Daniel Shevtsov
 */
public abstract class ComponentDecorator implements Car {

    //Keep the number of available decorators as a public constant
    public static final int NUM_DECORATORS = 5;

    protected Car car;
	
	public ComponentDecorator(Car car) {
		this.car = car;
	}
	
	@Override
	public String getInformation() {
		return car.getInformation();
	}
	
	@Override
	public double getPrice() {
		return car.getPrice();
	}
}
