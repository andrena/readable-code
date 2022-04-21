package de.andrena.readablecode.composition;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 1 implicit chunk given by the contract of the cart (sum of product prices = total, shipping = 0 if total > freeLimit)
 * 
 * Objects that use the full power of OO get hard to read even if there are 4 chunks, because in every method we must keep the contract in mind
 * 
 * The contract needs one chunk because we just store the reference to the contract and usually do not check it simultaneously with writing a method body 
 */
@SuppressWarnings("unused")
public class Cart1 {
	private List<Product1> products;
	private Date buyDate;
	private BigDecimal shipping; 
	private BigDecimal total;
	
	public void addProduct(Product1 product) {
		//add product and update totalPrice and shipping
	}
}
