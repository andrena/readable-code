package de.andrena.readablecode.stefan.naming.a;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;

public class Pricing {
	private double tax;

	public Pricing(double tax) {
		this.tax = tax;
	}

	/* Magic Complexity for Client =
	 *                +1     +1        +1 +1       +1       = 5
	 * only count words that are not trivial (we do not want to be pedantic whether GrossValue or ConsumerTax are one or two words)   
	 */
	public BigDecimal computeGrossValueAndSubstractConsumerTax(int amount, double price) {
		BigDecimal result = new BigDecimal((amount * price) / (1+tax));
		return result.setScale(2, HALF_UP);
	}
}
