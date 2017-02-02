/*
 * AUTHOR: Daniel Shevtsov (SID: 200351253 
 */

package com.shevtsod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderLine {
	private int quantity;
	private BigDecimal price;
	private List<Product> products;

    /**
     * Constructor. Initializes a product line
     */
    public OrderLine() {
        products = new ArrayList<>();
        price = new BigDecimal(0);
    }

    /**
	 * @return int quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void addProduct(Product p) {
	    //Ensure that only products of the same price are in this product line
        if(products.size() != 0 && products.get(0).getPricingDetails().equals(p.getPricingDetails()))
            return;

        products.add(p);
        quantity++;
        price = price.add(p.getPricingDetails());
    }

    public Product getProduct() {
        if(products.isEmpty())
            return null;
        else return products.get(0);    //All products are homogeneous, does not matter which we choose
    }
}
