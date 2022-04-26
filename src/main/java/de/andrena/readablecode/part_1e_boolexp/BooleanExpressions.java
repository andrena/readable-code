package de.andrena.readablecode.part_1e_boolexp;

public class BooleanExpressions {

	public static void main(String[] args) {
		System.out.println("\n1 chunk = ok");
		System.out.println("------------");
		new Formula((boolean a) -> true, "true").evaluate(true);
		new Formula((boolean a) -> a, "A").evaluate(true);

		System.out.println("\n3 chunks = ok");
		System.out.println("-------------");
		new Formula((a, b) -> a & b, "A & B").evaluate(true, false);

		System.out.println("\n4 chunks = ok");
		System.out.println("-------------");
		new Formula((a, b) -> a & !b, "A & !B").evaluate(true, false);
		new Formula((a, b) -> !a | b, "!A | B").evaluate(true, false);

		System.out.println("\n6 chunks = hard to recall");
		System.out.println("-------------");
		new Formula((a, b, c) -> a & b | !c, "A & B | !C").evaluate(true, false, false);
	}

}
