package com.shevtsod;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public class Reservoir {
    private String name;
    private double price;
    private int capacity;
    private int remaining;

    /**
     * Get the name of this Reservoir
     * @return String name of Reservoir
     */
    String getName() {
        return name;
    }

    /**
     * Set a new name for this Reservoir
     * @param name new String name of Reservoir
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Get the price of this Reservoir's contents per unit (price > 0)
     * @return double price
     */
    double getPrice() {
        return price;
    }

    /**
     * Set a new price for this Reservoir (price > 0)
     * @param price new double price of Reservoir
     */
    void setPrice(double price) {
        if(price > 0)
            this.price = price;
    }

    /**
     * Get the capacity of this Reservoir (capacity > 0)
     * @return int capacity of Reservoir
     */
    int getCapacity() {
        return capacity;
    }

    /**
     * Set a new capacity for this Reservoir (capacity > 0)
     * @param capacity new int capacity of Reservoir
     */
    void setCapacity(int capacity) {
        //When capacity is changed, set remaining capacity to match
        if(capacity > 0) {
            this.capacity = capacity;
            this.remaining = capacity;
        }
    }

    /**
     * Get the remaining stock of this reservoir (0 <= remaining <= capacity)
     * @return int remaining stock of Reservoir
     */
    int getRemaining() {
        return remaining;
    }

    /**
     * Set the new remaining stock of this reservoir (0 <= remaining <= capacity)
     * @param remaining new int remaining stock of Reservoir
     */
    void setRemaining(int remaining) {
        if(remaining >= 0 && remaining <= capacity)
            this.remaining = remaining;
    }
}
