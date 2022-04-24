package de.andrena.readablecode.chunking;

/**
 * see tests
 */
public class SideEffects {
	
	private int scalingFactor;
	
	public SideEffects(int scalingFactor) {
		this.scalingFactor = scalingFactor;
	}
	
	public int scale(int i) {
		return i * scalingFactor;
	}

	public int pureFunctional(int a, int b) {
		return a + b;
	}
	
	public int properOO(int a, int b) {
		return (a + b)* this.scalingFactor;
	}
	
	/**
	 * Haskell does not allow this
	 */
	public void mutableOO(int a) {
		this.scalingFactor = a;
	}

	/**
	 * Rust/Haskell do not allow this
	 */
	public SideEffects complexMutableOO(SideEffects that) {
		this.scalingFactor+= that.scalingFactor;
		return this;
	}

	/**
	 * Rust/Haskell do not allow this
	 */
	public SideEffects unconventionalMutableOO(SideEffects that) {
		that.scalingFactor+= this.scalingFactor;
		return that;
	}

}
