package de.andrena.readablecode.stefan.codeblocks.b;

import java.util.Deque;
import java.util.LinkedList;

public class Interpreter {
	
	private Deque<Object> stack;
	
	public Interpreter() {
		stack = new LinkedList<>();
	}
	
	public void push(Object o) {
		stack.push(o);
	}
	
	public Object pop() {
		return stack.pop();
	}

	public void swap() {
		/** Magic Complexity =           0 */
		Object op1 = stack.pop();      //+1
		Object op2 = stack.pop();      //+1
		stack.push(op1);               //+1
		stack.push(op2);               //+1
		/**                              4*/
	}


}
