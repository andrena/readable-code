package de.andrena.readablecode.abstractions;

import de.andrena.readablecode.composition.Product1;
import de.andrena.readablecode.part_1a_naming.Naming;

public class Abstractions {

	/**
	 * Abstraction by grouping cohesive attributes @see Product1
	 */
	public Product1 product1;

	/** 
	 * Abstraction by separating responsibilities  @see InTemporaryVariables 
	 * 
	 */
	public Naming.InTemporaryVariables naming;

	/**
	 * Abstraction is subject of almost every refactoring book  
	 */

}
