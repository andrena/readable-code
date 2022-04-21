package de.andrena.readablecode.boolexp;

import java.util.HashSet;
import java.util.Set;

public class SetTheory {

	private static final Set<String> ALL = Set.of("lemons","oranges", "apples", "strawberries", "onions", "carrots","paprika","zucchini");

		public static void main(String[] args) {
		System.out.println("\n1 chunk = ok");
		System.out.println("------------");
		new SetFormula((Set<String> a) -> a, "A").evaluate(Set.of("lemons","onions"));

		System.out.println("\n3 chunks = ok");
		System.out.println("-------------");
		new SetFormula((a, b) -> intersect(a,b), "A & B").evaluate(Set.of("lemons","onions"), Set.of("lemons","oranges"));

		System.out.println("\n3 chunks (with combinatoric explosion) = unpredictable");
		System.out.println("-------------");
		new SetFormula((a, b) -> intersect(a,not(b)), "A & !B").evaluate(Set.of("lemons","onions"), Set.of("lemons","oranges"));
		new SetFormula((a, b) -> union(not(a),b), "!A | B").evaluate(Set.of("lemons","onions"), Set.of("lemons","oranges"));
	}

	private static Set<String> intersect(Set<String> a, Set<String> b) {
		Set<String> set = new HashSet<>();
		set.addAll(a);
		set.retainAll(b);
		return set;
	}

	private static Set<String> union(Set<String> a, Set<String> b) {
		Set<String> set = new HashSet<>();
		set.addAll(a);
		set.addAll(b);
		return set;
	}
	
	private static Set<String> not(Set<String> a) {
		Set<String> set = new HashSet<>();
		set.addAll(ALL);
		set.removeAll(a);
		return set;
	}
}
