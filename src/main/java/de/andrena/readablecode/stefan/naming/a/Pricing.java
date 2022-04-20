package de.andrena.readablecode.stefan.naming.a;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;

public class Pricing {
	private double tax;

	public Pricing(double tax) {
		this.tax = tax;
	}

	public BigDecimal computeGrossValueAndSubstractConsumerTax(int amount, double price) {
		BigDecimal result = new BigDecimal((amount * price) / (1+tax));
		return result.setScale(2, HALF_UP);
	}
}
