/*
 * AUTHOR: Daniel Shevtsov (SID: 200351253 
 */

package com.shevtsod;

import java.math.BigDecimal;

public class Product {
    private BigDecimal price;

    /**
     * Constructor. Creates a new product with a given price
     * @param price
     *      BigDecimal price of the product
     */
    public Product(BigDecimal price) {
        this.price = price;
    }

    /**
     * Returns the pricing details of this product
     * @return BigDecimal pricing details
     */
    public BigDecimal getPricingDetails() {
        return price;
    }

}
