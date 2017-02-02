/*
 * AUTHOR: Daniel Shevtsov (SID: 200351253 
 */

package com.shevtsod;

import java.math.BigDecimal;

public class CorporateCustomer extends Customer {

    private String contactName;
    private BigDecimal creditLimit;

    /**
     * Constructor. Initializes a corporate customer
     */
    public CorporateCustomer(String name, String address, char rating, String contactName, BigDecimal creditLimit) {
        super(name, address, rating);
        this.contactName = contactName;
        this.creditLimit = creditLimit;
    }

    /**
     * Bill the corporate customer for a month
     * @param in
     *      Integer to bill the customer
     */
    public void billForMonth(int in) {
        //No implementation or usage specified
    }

    /**
     * Remind the corporate customer
     */
    public void remind() {
        //No implementation or usage specified
    }


}
