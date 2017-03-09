package com.shevtsod.Reservoir;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public interface Reservoir {
    /**
     * Get the name of this Reservoir
     * @return String name of Reservoir
     */
    String getName();

    /**
     * Set a new name for this Reservoir
     * @param name new String name of Reservoir
     */
    void setName(String name);

    /**
     * Get the price of this Reservoir's contents per unit (price > 0)
     * @return double price
     */
    double getPrice();

    /**
     * Set a new price for this Reservoir (price > 0)
     * @param price new double price of Reservoir
     */
    void setPrice(double price);

    /**
     * Get the capacity of this Reservoir (capacity > 0)
     * @return int capacity of Reservoir
     */
    int getCapacity();

    /**
     * Set a new capacity for this Reservoir (capacity > 0)
     * @param capacity new int capacity of Reservoir
     */
    void setCapacity(int capacity);

    /**
     * Get the remaining stock of this reservoir (0 <= remaining <= capacity)
     * @return int remaining stock of Reservoir
     */
    int getRemaining();

    /**
     * Set the new remaining stock of this reservoir (0 <= remaining <= capacity)
     * @param remaining new int remaining stock of Reservoir
     */
    void setRemaining(int remaining);
}
