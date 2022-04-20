package de.andrena.readablecode.stefan.teaser.b;

public class Swap {

	public static <T> Pair<T> swap (Pair<T> pair) {
		return new Pair<>(pair.right(), pair.left());
	}
}
