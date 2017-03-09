package com.shevtsod.Reservoir;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class CustomReservoirCapacity extends CustomReservoir {
    private int capacity;
    private int remaining;

    /**
     * Constructor, calls parent's constructor
     * @param reservoir The decorated Reservoir
     */
    public CustomReservoirCapacity(Reservoir reservoir) {
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
        return reservoir.getPrice();
    }

    @Override
    public void setPrice(double price) {
        reservoir.setPrice(price);
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        //When capacity is changed, set remaining capacity to match
        if(capacity > 0) {
            this.capacity = capacity;
            this.remaining = capacity;
        }
    }

    @Override
    public int getRemaining() {
        return remaining;
    }

    @Override
    public void setRemaining(int remaining) {
        if(remaining >= 0 && remaining <= capacity)
            this.remaining = remaining;
    }
}
