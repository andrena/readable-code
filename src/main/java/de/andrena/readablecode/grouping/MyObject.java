package de.andrena.readablecode.grouping;

public class MyObject {

	private int value;

	public MyObject(int value) {
		this.value = value;
	}

	public MyObject mult(MyObject that) {
		int value1 = this.value(); // both lines are symmetric
		int value2 = that.value(); // so group them together

		int product = value1 * value2; // this line has the business logic

		return new MyObject(product); // this line just wraps up
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}

}