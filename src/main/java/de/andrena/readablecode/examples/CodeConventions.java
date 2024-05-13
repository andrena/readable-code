package de.andrena.readablecode.examples;

public class CodeConventions {

	/**
	 * Convention:
	 * - do not use short circuit returns for equal alternatives 
	 */
	public String helpful(int number) {
		if (number % 15 == 0) {
			return "FizzBuzz";
		} else if (number % 3 == 0) {
			return "Fizz";
		} else if (number % 5 == 0) {
			return "Buzz";
		} else {
			return String.valueOf(number);
		}
	}

	/**
	 * Non uniform convention:
	 * - return nulls if something gets wrong
	 * - return exceptions if something gets wrong
	 * - return runtime exceptions if something gets wrong
	 * - return optionals if something gets wrong
	 * - return result object if something gets wrong 
	 */
	public void hard(String source) {
		var astNode = parse(source);
		
		// should we check on null? 
		// Or is it an optional? 
		// Or a more complex result object? 
		// Or should we catch an exception? 
		// Or even multiple of the known alternatives?  

		System.out.println(astNode);
}

	private Object parse(String source) {
		return null;
	}

	/**
	 * Non existing Convention:
	 * - always use braces for scoping conditional bodies
	 * - always use the common formatter (which removes false indents)
	 */
	public void misleading() {
		String text;
		if ((text = open()) != null)
			execute(text);
   		    close();
	}

	private String open() {
		return null;
	}

	private void execute(String text) {
	}

	private void close() {
	}

	interface Node {
		
	}
}
