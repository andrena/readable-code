package de.andrena.readablecode.stefan.naming.b;

public class Pricing {
	private double tax;

	public Pricing(double tax) {
		this.tax = tax;
	}
	
	public Price computePrice(int amount, double price) {
		return new Price(amount * price, tax);
	}
}
