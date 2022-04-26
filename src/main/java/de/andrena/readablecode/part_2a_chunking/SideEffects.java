package de.andrena.readablecode.part_2a_chunking;

/**
 * see tests
 */
public class SideEffects {
	
	private int unitSize;
	
	public SideEffects(int unitSize) {
		this.unitSize = unitSize;
	}
	
	public int sizeOf(int i) {
		return i * unitSize;
	}

	public int add(int a, int b) {
		return a + b;
	}
	
	public int addUnits(int a, int b) {
		return (a + b)* this.unitSize;
	}
	
	/**
	 * Haskell does not allow this
	 */
	public void setUnitSize(int a) {
		this.unitSize = a;
	}

	/**
	 * Rust/Haskell do not allow this
	 */
	public SideEffects add(SideEffects that) {
		this.unitSize+= that.unitSize;
		return this;
	}

	/**
	 * Rust/Haskell do not allow this
	 */
	public SideEffects plus(SideEffects that) {
		that.unitSize+= this.unitSize;
		return that;
	}

}
