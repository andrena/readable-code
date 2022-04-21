package de.andrena.readablecode.codeblocks;

import java.util.LinkedList;
import java.util.ListIterator;

public class Stack {
	
	private LinkedList<Object> stack;
	
	public Stack() {
		stack = new LinkedList<>();
	}
	
	public void push(Object o) {
		stack.push(o);
	}
	
	public Object pop() {
		return stack.pop();
	}

	public void swap() {
		swap2();
	}

	/** 4 chunks (statements) = understandable */
	public void swap1() {
		Object top = stack.pop();      
		Object belowTop = stack.pop(); 
		stack.push(top);               
		stack.push(belowTop);          
	}

	/** 9 chunks (statements, conditions) = understanding needs symbolic execution */
	public void swap2() {
		ListIterator<Object> it = stack.listIterator(stack.size());              
		Object current = null;                                                   
		Object next = null;                                                      
		while (it.hasPrevious() && (current == null || next == null)) {          
			if (current == null) {                                               
				current = it.previous();                                         
			} else {                                                             
				next = it.previous();                                            
			}
		}
		stack.set(stack.size() - 2, current);                                    
		stack.set(stack.size() - 1, next);                                       
	}


}
