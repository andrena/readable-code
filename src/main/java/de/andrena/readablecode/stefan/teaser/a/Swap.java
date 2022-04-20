package de.andrena.readablecode.stefan.teaser.a;

public class Swap {

	public static <T> Pair<T> swap (Pair<T> pair) {
		T t = pair.left;
		pair.left = pair.right;
		pair.right = t;
		return pair;
	}
}
