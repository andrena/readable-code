package de.andrena.readablecode.stefan.naming.b;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;

public class Price {

	private double gross;
	private double tax;

	public Price(double gross, double tax) {
		this.gross = gross;
		this.tax = tax;
	}

	public BigDecimal netValue() {
		BigDecimal result = new BigDecimal(gross / (1 + tax));
		return result.setScale(2, HALF_UP);
	}
}
