package com.shevtsod.componentdecorators;

import com.shevtsod.Car;
import com.shevtsod.ComponentDecorator;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class EntertainmentDec extends ComponentDecorator {
    private double price = 487.93;

    public EntertainmentDec(Car car) {
        super(car);
    }

    @Override
    public String getInformation() {
        return car.getInformation() + "\n + Entertainment Package";
    }

    @Override
    public double getPrice() {
        return car.getPrice() + price;
    }
}
