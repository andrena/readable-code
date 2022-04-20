package de.andrena.readablecode.stefan.teaser.a;

public class Pair<T> {
	public T left;
	public T right;

	public Pair(T left, T right) {
		this.left = left;
		this.right = right;
	}

	public T left() {
		return left;
	}
	
	public T right() {
		return right;
	}
}
