package de.andrena.readablecode.groupingandaligning;

import de.andrena.readablecode.part_1f_codeconventions.CodeConventions;

public class GroupingAligning {

	/**
	 * do not violate conventional formattings @see CodeConventions
	 */
	public CodeConventions conventions;

	/**
	 * use grouping, scoping, blank lines
	 */
	public MyObject mult(MyObject o1, MyObject o2) {
		int value1 = o1.value();           // both lines are symmetric
		int value2 = o2.value();           // so group them together

		int product = value1 * value2;     // this line has the business logic

		return new MyObject(product);      // this line just wraps up
	}

	/** 
	 * grouping can also be found in testing best practices:
	 * - use AAA(Arrange-Act-Assert)-Pattern
	 * - also known as Given-When-Then-Pattern 
	 */
	public void swap(MyObject o1, MyObject o2) {
		int t1 = o1.value();
		int t2 = o2.value();
		o1.setValue(t2);
		o2.setValue(t1);
	}

	public static class MyObject {

		private int value;

		public MyObject(int value) {
			this.value = value;
		}

		public MyObject() {
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int value() {
			return value;
		}

	}

}
