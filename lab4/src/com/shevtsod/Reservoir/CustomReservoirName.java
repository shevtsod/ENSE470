package com.shevtsod.Reservoir;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class CustomReservoirName extends CustomReservoir {
    private String name;

    /**
     * Constructor, calls parent's constructor
     * @param reservoir The decorated Reservoir
     */
    public CustomReservoirName(Reservoir reservoir) {
        super(reservoir);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return reservoir.getPrice();
    }

    @Override
    public void setPrice(double price) {
        reservoir.setPrice(price);
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
