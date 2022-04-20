package de.andrena.readablecode.stefan.codeblocks.a;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Interpreter {

	private List<Object> stack;

	public Interpreter() {
		stack = new LinkedList<>();
	}

	public void push(Object o) {
		stack.add(o);
	}

	public Object pop() {
		return stack.remove(stack.size() - 1);
	}

	public void swap() {
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

}
