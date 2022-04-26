package de.andrena.readablecode.part_1e_boolexp;

import java.util.Set;
import java.util.function.Function;

public class SetFormula {

	private static String[] VARIABLES = {"A","B","C"};
	
	private Function<Set<String>[],Set<String>> formula;
	private String toString;

	public SetFormula(P1 formula, String toString) {
		this((Set<String>[] a) -> formula.test(a[0]), toString);
	}

	public SetFormula(P2 formula, String toString) {
		this((Set<String>[] a) -> formula.test(a[0], a[1]), toString);
	}
	
	public SetFormula(P3 formula, String toString) {
		this((Set<String>[] a) -> formula.test(a[0], a[1],a[2]), toString);
	}
	
	public SetFormula(Function<Set<String>[],Set<String>> formula, String toString) {
		this.formula = formula;
		this.toString = toString;
	}
	
	@SafeVarargs
	public final void evaluate(Set<String>... arguments) {
		int i = 0;
		for (Set<String> arg : arguments) {
			System.out.println(VARIABLES[i] + " = " + arg);
			i++;
		}
		System.out.print("\t" + toString + " = ");
		Set<String> test = formula.apply(arguments);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		System.out.println(test);
	}

	public interface P1 {

		Set<String> test(Set<String> a);

	}

	public interface P2 {

		Set<String> test(Set<String> a, Set<String> b);

	}

	public interface P3 {

		Set<String> test(Set<String> a, Set<String> b, Set<String> c);

	}
}
