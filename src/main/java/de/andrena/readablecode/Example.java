package de.andrena.readablecode;

public class Example {
	public int hard(int x) {
		var y = 0;
		var z = 1;

		var o = 0;
		for (int i = 0; i < x; i++) {
			o = o + y * x + z;
		}
		return o;
	}

}
