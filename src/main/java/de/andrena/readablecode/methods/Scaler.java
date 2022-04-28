package de.andrena.readablecode.methods;

/**
 * see tests
 */
public class Scaler {
	
	private int factor;
	
	public Scaler(int unitSize) {
		this.factor = unitSize;
	}
	
	public int scale(int i) {
		return i * factor;
	}

	private int add(int a, int b) {
		return a + b;
	}
	
	public int addUnits(int a, int b) {
		return add(a, b)* this.factor;
	}
	
	/**
	 * Haskell does not allow this
	 */
	public void setFactor(int a) {
		this.factor = a;
	}

	/**
	 * Rust/Haskell do not allow this
	 */
	public Scaler add(Scaler that) {
		this.factor+= that.factor;
		return this;
	}

	/**
	 * Rust/Haskell do not allow this
	 */
	public Scaler plus(Scaler that) {
		that.factor+= this.factor;
		return that;
	}

	public static void main(String[] args) {
		final Scaler x = new Scaler(1);
		final Scaler y = new Scaler(2);
		final Scaler z = new Scaler(4);
		
		Scaler sumXY = x.plus(y);
		System.out.println("sumXY is: " + sumXY.scale(1));
		Scaler sumXYZ = z.plus(y);
		//System.out.println("sumXYZ is: " + sumXYZ.scale(1));
		//System.out.println("sumXY is: " + sumXY.scale(1));
		//System.out.println("x is: " + x.scale(1));
		//System.out.println("y is: " + y.scale(1));
		//System.out.println("z is: " + z.scale(1));
		
	}
}
