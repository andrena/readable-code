package de.andrena.readablecode.composition;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * As class we have to adjust the chunk counting:
 * - attribute products          +1
 * - attribute buyDate           +1
 * - attribute shipping          +1
 * - attribute total             +1
 * - contract of the class       +1
 * 
 * total chunks                  5 (not easy to recall)
 * 
 * Just using the attributes of a class does not involve the class contract (so there would be 4 chunks)
 * But every method we call has to obey the contract (we have to keep the contract in mind, when using the attributes)
 * We assume that this contract is available as one chunk (so there are 5 chunks)  
 * 
 * Note: The contract is not always explicit and often not even completely defined, in this case we can assume following:
 * - sum of product prices = total 
 * - shipping = 0 if total > FREE_LIMIT
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
