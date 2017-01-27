/*
 * AUTHOR: Daniel Shevtsov (SID: 200351253 
 */

package com.shevtsod;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	private Date dateReceived;
	private boolean isPrepaid;
	private String number;
	private BigDecimal price;
	private Customer customer;
	
	public void dispatch() {
		//No implementation specified
	}
	
	public BigDecimal calculateBasePrice() {
		//TODO: Add this method
		return new BigDecimal(0);
	}
	
	public BigDecimal calculateDiscountss() {
		//TODO: Add this method
		return new BigDecimal(0);
	}
	
	public void close() {
		//No implementation specified
	}
}
