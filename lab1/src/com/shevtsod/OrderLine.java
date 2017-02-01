/*
 * AUTHOR: Daniel Shevtsov (SID: 200351253 
 */

package com.shevtsod;

import java.math.BigDecimal;

public class OrderLine {
	private int quantity;
	private BigDecimal price;
	//TODO: Add Product collection here

	/**
	 * @return int quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}
}
