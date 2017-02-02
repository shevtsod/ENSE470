/*
 * AUTHOR: Daniel Shevtsov (SID: 200351253 
 */

package com.shevtsod;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private Date dateReceived;
	private boolean isPrepaid;
	private String number;
	private BigDecimal price;
	private Customer customer;
	List<OrderLine> orderLines;

	/**
	 * Constructor. Initializes an order
	 * @param c
	 * 		The customer initializing this order
	 */
	public Order(Customer c) {
		dateReceived = new Date();
		dateReceived.setTime(dateReceived.getTime());
		price = new BigDecimal(0);
		customer = c;
		isPrepaid = c.getCreditRating() > 'C';		//Assume D, E, F are considered 'poor' credit rating
		number = "";								//The purpose of this string is unspecified

        orderLines = new ArrayList<>();
	}

	/**
	 * Dispatches an order
	 */
	public void dispatch() {
		//No implementation specified
	}

	/**
	 * Calculates the base price of all products in the order
	 * @return BigDecimal price of the products
	 */
	public BigDecimal calculateBasePrice() {
	    return price;
	}

	/**
	 * Calculates the discounts towards the customer, depending on the customer's financial status
	 * @return BigDecimal discounts to this order
	 */
	public BigDecimal calculateDiscounts() {
		return customer.getDiscountInfo();
	}

	/**
	 * Closes the order
	 */
	public void close() {
		//No implementation specified
	}

    /**
     * Get the total price of this order
     * @return
     *      BigDecimal price of the order
     */
	public BigDecimal calculatePrice() {
	    int quantity = 0;
	    BigDecimal initialPrice = new BigDecimal(0);
	    BigDecimal discountMult = new BigDecimal(1);

		for(OrderLine ol : orderLines) {
		    quantity += ol.getQuantity();
        }

        System.out.println("\tNumber of products: " + quantity);

		for(OrderLine ol : orderLines) {
		    initialPrice = initialPrice.add(ol.getProduct().getPricingDetails());
        }

        //Make sure the price is consistent
        if(!initialPrice.equals(calculateBasePrice()))
            System.out.println(" - ERROR: Mismatch in price calculation");

		discountMult = discountMult.subtract(calculateDiscounts());

		//Multiply price by the discount to get the final price
        return initialPrice.multiply(discountMult);
	}

    /**
     * Adds any product p to the order and sorts it in ascending price order by placing it into the
     * correct order list
     * @param p
     *      The product to be added to this order
     */
	public void addProduct(Product p) {
	    //Check if the product exists in any order line yet (based on price)
        if(!orderLines.isEmpty()) {
            orderLines.forEach((ol) -> {        //Java 8 syntax
                //If it is, add it to that order line
                if(ol.getPrice().equals(p.getPricingDetails()))
                    ol.addProduct(p);
            });
        }

        //If it isn't, create a new order line and add this product to it
        OrderLine ol = new OrderLine();
        ol.addProduct(p);
        orderLines.add(ol);

        //Add this product's pricing details to the order's total
        price = price.add(p.getPricingDetails());
    }
}
