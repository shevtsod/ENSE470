package com.shevtsod.Reservoir;

/**
 * @author Daniel Shevtsov (SID: 200351253)
 */
public abstract class CustomReservoir implements Reservoir {
    protected Reservoir reservoir;

    /**
     * Constructor for a Reservoir decorator. Takes a reference to the Reservoir to be decorated to store
     * @param reservoir The decorated Reservoir
     */
    public CustomReservoir(Reservoir reservoir) {
        this.reservoir = reservoir;
    }

    // An abstract class does not have to implement its interface's methods
}
