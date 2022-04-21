package de.andrena.readablecode.boolexp;

import java.util.function.Predicate;

public class Formula {

	private static String[] VARIABLES = {"A","B","C"};
	
	private Predicate<boolean[]> formula;
	private String toString;

	public Formula(P1 formula, String toString) {
		this((boolean[] a) -> formula.test(a[0]), toString);
	}

	public Formula(P2 formula, String toString) {
		this((boolean[] a) -> formula.test(a[0], a[1]), toString);
	}
	
	public Formula(P3 formula, String toString) {
		this((boolean[] a) -> formula.test(a[0], a[1],a[2]), toString);
	}
	
	public Formula(Predicate<boolean[]> formula, String toString) {
		this.formula = formula;
		this.toString = toString;
	}

	public void evaluate(boolean... arguments) {
		int i = 0;
		for (boolean arg : arguments) {
			System.out.println(VARIABLES[i] + " = " + arg);
			i++;
		}
		System.out.print("\t" + toString + " = ");
		boolean test = formula.test(arguments);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(test);
	}

	public interface P1 {

		boolean test(boolean a);

	}

	public interface P2 {

		boolean test(boolean a, boolean b);

	}

	public interface P3 {

		boolean test(boolean a, boolean b, boolean c);

	}
}
