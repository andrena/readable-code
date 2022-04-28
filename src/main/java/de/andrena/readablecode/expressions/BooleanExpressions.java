package de.andrena.readablecode.expressions;

public class BooleanExpressions {

	public static void main(String[] args) {
		new Formula((boolean a) -> a,
			"A").evaluate(true);
		System.out.println("\nwas 1 chunk\n\n");

		new Formula((a, b) -> a & b,
			"A & B").evaluate(true, false);
		System.out.println("\n was 3 chunks\n\n");

		new Formula((a, b) -> a & !b,
			"A & !B").evaluate(true, false);
		new Formula((a, b) -> !a | b,
			"!A | B").evaluate(true, false);
		System.out.println("\n was 4 chunks\n\n");

		new Formula((a, b, c) -> a & b | !c,
			"A & B | !C").evaluate(true, false, false);
		System.out.println("\n was 6 chunks (gets hard)\n\n");
	}

}
