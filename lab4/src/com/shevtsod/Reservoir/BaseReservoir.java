package com.shevtsod.Reservoir;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class BaseReservoir implements Reservoir {
    //Default values for a base reservoir
    private static String BASE_NAME     = "Unnamed";
    private static double BASE_PRICE    = 0.00;
    private static int BASE_CAPACITY    = 1;

    @Override
    public String getName() {
        return BASE_NAME;
    }

    @Override
    public void setName(String name) {
        // Do nothing, the base reservoir maintains its name
        // This behaviour is overriden by decorators
    }

    @Override
    public double getPrice() {
        return BASE_PRICE;
    }

    @Override
    public void setPrice(double price) {
        // Do nothing, the base reservoir maintains its price
        // This behaviour is overriden by decorators
    }

    @Override
    public int getCapacity() {
        return BASE_CAPACITY;
    }

    @Override
    public void setCapacity(int capacity) {
        // Do nothing, the base reservoir maintains its name
        // This behaviour is overriden by decorators
    }

    @Override
    public int getRemaining() {
        return BASE_CAPACITY;
    }

    @Override
    public void setRemaining(int remaining) {
        // Do nothing, the base reservoir maintains its name
        // This behaviour is overriden by decorators
    }
}
