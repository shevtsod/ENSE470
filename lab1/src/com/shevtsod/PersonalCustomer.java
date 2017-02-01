/*
 * AUTHOR: Daniel Shevtsov (SID: 200351253 
 */

package com.shevtsod;

public class PersonalCustomer extends Customer {
    private String creditCardNumber;

    /**
     * @return String creditCardNumber
     */
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Set this PersonalCustomer's credit card number
     * @param creditCardNumber
     *      String credit card number
     */
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
