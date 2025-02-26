package de.andrena.readablecode.expressions;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class ImpDecl {

	public static void main(String[] args) {
		new ImpDecl().run();
	}

	public void run() {
		doIt(3, 2, 4, 2, 2);
		expSumAndRoot(3, 2, 4, 2, 2);
		new Vec(3,4).norm();
	}

	private double doIt(double a, int expA, double b, int expB, double root) {
		var exp = a;
		exp *= a;
		exp += b * b;
		exp = pow(exp, 1 / 2);
		return exp;
	}

	private double expSumAndRoot(double a, int expA, double b, int expB, double root) {
		double aSquared = a * a;
		double bSquared = b * b;
		return sqrt(aSquared + bSquared);
	}
}

record Vec(double a, double b) {

	public double norm() {
		return sqrt(a*a + b*b);
	}

}
