package de.andrena.readablecode.expressions;

import java.util.List;

public class CombinerMain {
	private static final String OP1 = "sum";
	private static final String OP2 = "product";

	public static void main(String[] args) {
		Combiner c = new Combiner();
		for (int arg = 1; arg < args.length; arg++) { 
			c.combine(args[arg]); 
		}
		if (args[0].equals(OP1)) {
			System.out.println("Sum = " + c.build()); 
		} else if (args[0].equals(OP2)) {
			System.out.println("Product = " + c.buildMult());
		}
	}
}

class Combiner {
	private List<Long> c;

	public Combiner combine(String s) {
		var p = Long.parseLong(s);
		c.add(p);
		return this;
	}

	public long build() {
		var i = 0;
		var a = 0;
		do {
			i += c.get(a);
		} while (a < c.size());
		return i;
	}

	public long buildMult() {
		var sum = 1L;
		for (long summand : c) {
			sum = sum * summand;
		}
		return sum;
	}

}
