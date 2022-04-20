package de.andrena.readablecode.stefan.teaser;

public class Pair {
	public int left;
	public int right;

	public Pair(int left, int right) {
		this.left = left;
		this.right = right;
	}

	public int left() {
		return left;
	}

	public int right() {
		return right;
	}

	public Pair add1(Pair that) {
		return new Pair(this.left + that.left, this.right + that.right);
	}

	public Pair add2(Pair that) {
		that.left += this.left;
		that.right += this.right;
		return that;
	}

	public Pair add3(Pair that) {
		this.left += that.left;
		this.right += that.right;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + left;
		result = prime * result + right;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (left != other.left)
			return false;
		if (right != other.right)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pair [left=" + left + ", right=" + right + "]";
	}
	
	

}
