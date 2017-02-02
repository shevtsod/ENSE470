/*
 * AUTHOR: Daniel Shevtsov (SID: 200351253 
 */

package com.shevtsod;

import java.math.BigDecimal;

public abstract class Customer {
    protected String name;
    protected String address;
    protected char rating;

    /**

     * Constructor. Initializes a new Customer with given data
     *
     * @param name    Name of the customer
     * @param address Billing address of the customer
     * @param rating  char representing credit rating from A (best) to F (worst)
     */
    public Customer(String name, String address, char rating) {
        this.name = name;
        this.address = address;

        rating = Character.toUpperCase(rating);
        if (rating < 'A' || rating > 'F') rating = 'F';
        this.rating = rating;
    }

    /**
     * Returns the credit rating of this customer
     *
     * @return char representing credit rating from A (best) to F (worst)
     */
    public char getCreditRating() {
        return rating;
    }

    /**
     * Returns the decimal fraction discount awarded to this customer on purchases
     *
     * @return BigDecimal decimal fraction (range 0.00 to 1.00)
     */
    public BigDecimal getDiscountInfo() {
        switch (rating) {
            case 'A':
                return new BigDecimal(0.5);
            case 'B':
                return new BigDecimal(0.4);
            case 'C':
                return new BigDecimal(0.3);
            case 'D':
                return new BigDecimal(0.2);
            case 'E':
                return new BigDecimal(0.1);
            case 'F': default:
                return new BigDecimal(0);
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}

