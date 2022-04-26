package de.andrena.readablecode.part_0_teaser;

public class MyInteger {
	public int value;

	public MyInteger(int value) {
		this.value = value;
	}
	
	public MyInteger add1(MyInteger that) {
		return new MyInteger(this.value + that.value);
	}

	public MyInteger add2(MyInteger that) {
		this.value += that.value;
		return this;
	}

	public MyInteger add3(MyInteger that) {
		that.value += this.value;
		return that;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyInteger that = (MyInteger) obj;
		return this.value == that.value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public MyInteger add(MyInteger that) {
		return add3(that);
	}
	
	

}
