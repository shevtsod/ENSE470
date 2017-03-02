package com.shevtsod.componentdecorators;

import com.shevtsod.Car;
import com.shevtsod.ComponentDecorator;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class DrivetrainDec extends ComponentDecorator {
    private double price = 2500.00;

    public DrivetrainDec(Car car) {
        super(car);
    }

    @Override
    public String getInformation() {
        return car.getInformation() + "\n + Drivetrain Package";
    }

    @Override
    public double getPrice() {
        return car.getPrice() + price;
    }
}
