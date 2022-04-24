package de.andrena.readablecode.chunking;

import de.andrena.readablecode.teaser.MyInteger;

public class SideEffects {
	
	private int scalingFactor;
	
	public SideEffects(int scalingFactor) {
		this.scalingFactor = scalingFactor;
	}

	/**
	 * 3 chunks (pureFunctional, a, b) = ok
	 */
	public int pureFunctional(int a, int b) {
		return a + b;
	}
	
	/**
	 * 4 chunks (properOO, this, a, b) = ok
	 */
	public int properOO(int a, int b) {
		return (a + b)* this.scalingFactor;
	}
	
	/**
	 * 3  chunks (mutableOO, this, a) 
	 * 1 chunk to keep in mind that this method changes the this object
	 * 4 chunks = ok
	 * 
	 * Haskell does not allow this
	 */
	public void mutableOO(int a) {
		this.scalingFactor = a;
	}

	/**
	 * @see MyInteger.add2
	 * 3 chunks (complexMutableOO, this, that)
	 * 1 chunk to keep in mind that this method changes the this object
	 * 
	 * The implicit convention in OO is:
	 * 1. methods with result do not mutate the object or argument (Command-Query-Segregation-Principle)
	 * 2. methods may have side effects on this-object, but not the arguments
	 * 
	 * this method violates 1. (also found in common Builder Pattern)
	 * 
	 * 1 additional chunk because the convention is violated
	 * 
	 * 5 chunks = not easy to recall
	 * 
	 * Rust/Haskell do not allow this
	 */
	public SideEffects complexMutableOO(SideEffects that) {
		this.scalingFactor+= that.scalingFactor;
		return this;
	}

	/**
	 * @see MyInteger.add3
	 * 3 chunks (complexMutableOO, this, that)
	 * 1 chunk to keep in mind that this method changes the this object
	 * 
	 * The implicit convention in OO is:
	 * 1. methods with result do not mutate the object or argument (Command-Query-Segregation-Principle)
	 * 2. methods may have side effects on this-object, but not the arguments
	 * 
	 * this method violates 1. and 2.
	 * 
	 * 1 additional chunk because convention 1 is violated
	 * 1 additional chunk because convention 2 is violated
	 * 
	 * 6 chunks = hard to recall
	 * 
	 * Rust/Haskell do not allow this
	 */
	public SideEffects unconventionalMutableOO(SideEffects that) {
		that.scalingFactor+= this.scalingFactor;
		return that;
	}
}
