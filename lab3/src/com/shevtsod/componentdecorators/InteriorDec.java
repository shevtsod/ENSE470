package com.shevtsod.componentdecorators;

import com.shevtsod.Car;
import com.shevtsod.ComponentDecorator;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class InteriorDec extends ComponentDecorator {
    private double price = 4750.50;

    public InteriorDec(Car car) {
        super(car);
    }

    @Override
    public String getInformation() {
        return car.getInformation() + "\n + Premium Interior Package";
    }

    @Override
    public double getPrice() {
        return car.getPrice() + price;
    }
}
