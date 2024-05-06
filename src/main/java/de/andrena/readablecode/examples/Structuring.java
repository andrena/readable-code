package de.andrena.readablecode.examples;

import java.text.NumberFormat;

public class Structuring {

	public static void main(String[] args) {
		Coordinates coordinates = new Coordinates(3, 4);

		System.out.println(coordinates.bad());
	}

}

class Coordinates {
	public Number x;
	public Number y;

	public Coordinates(double x, double y) {
		this.x = new Number(x);
		this.y = new Number(y);
	}

	public Number norm() {
		double xSquared = x.value * x.value;
		double ySquared = y.value * y.value;

		double sum = xSquared + ySquared;

		double norm = Math.sqrt(sum);

		return new Number(norm);
	}

	public Number bad() {
		double result = x.value;
		result *= x.value;
		result = result + y.value * y.value;
		result = Math.sqrt(result);
		return new Number(result);
	}

}

class Number {

	public double value;

	public Number(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return NumberFormat.getInstance().format(value);
	}
}
