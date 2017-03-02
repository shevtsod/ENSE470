package com.shevtsod;

/**
 * @author Daniel Shevtsov
 */
public interface Car {
    /**
     * Get a string describing all of the information on this Car object
     * @return String containing information on this Car object
     */
	String getInformation();

    /**
     * Get the price of this Car object
     * @return double price
     */
	double getPrice();
}
