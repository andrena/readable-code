package de.andrena.readablecode.stefan.codeblocks;

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
		swap1();
	}

	public void swap2() {
		/** Magic Complexity =                                                     0 */
		ListIterator<Object> it = stack.listIterator(stack.size());              //+1
		Object current = null;                                                   //+1
		Object next = null;                                                      //+1
		while (it.hasPrevious() && (current == null || next == null)) {          //+1
			if (current == null) {                                               //+1
				current = it.previous();                                         //+1
			} else {                                                             //+1
				next = it.previous();                                            //+1
			}
		}
		stack.set(stack.size() - 2, current);                                    //+1
		stack.set(stack.size() - 1, next);                                       //+1
		/**                                                                        10*/
	}

	public void swap1() {
		/** Magic Complexity =           0 */
		Object top = stack.pop();      //+1
		Object belowTop = stack.pop(); //+1
		stack.push(top);               //+1
		stack.push(belowTop);          //+1
		/**                              4*/
	}


}
