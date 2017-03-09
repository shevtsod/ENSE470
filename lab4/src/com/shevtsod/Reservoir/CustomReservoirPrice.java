package com.shevtsod.Reservoir;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class CustomReservoirPrice extends CustomReservoir {
    private double price;

    /**
     * Constructor, calls parent's constructor
     * @param reservoir The decorated Reservoir
     */
    public CustomReservoirPrice(Reservoir reservoir) {
        super(reservoir);
    }

    @Override
    public String getName() {
        return reservoir.getName();
    }

    @Override
    public void setName(String name) {
        reservoir.setName(name);
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        if(price > 0)
            this.price = price;
    }

    @Override
    public int getCapacity() {
        return reservoir.getCapacity();
    }

    @Override
    public void setCapacity(int capacity) {
        reservoir.setCapacity(capacity);
    }

    @Override
    public int getRemaining() {
        return reservoir.getRemaining();
    }

    @Override
    public void setRemaining(int remaining) {
        reservoir.setRemaining(remaining);
    }
}
