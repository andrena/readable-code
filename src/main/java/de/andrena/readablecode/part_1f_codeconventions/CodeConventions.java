package de.andrena.readablecode.part_1f_codeconventions;

public class CodeConventions {

	/**
	 * multiple chunks - each statement/expression and the body is readable  
	 */
	public String conventional(String s, int count) {
		StringBuilder buffer = new StringBuilder();
		buffer.append('(');
		for (int i = 0; i < count; i++) {
			if (i > 0) {
				buffer.append(',');
			}
			buffer.append(s);
		}
		buffer.append(')');
		return buffer.toString();
	}

	/**
	 * multiple chunks - but each line is a surprise
	 * surprises occupy operand space to understand and disturb readability
	 */
	public String unconventional(String a, int i) {  //why a?, why i?
		StringBuilder c = new StringBuilder();       //why c
		c.append('(');
		for (int j = 0; j < i; j++)                  //which is the iteration variable i oder j?
		{                                            //parentheses on the next line, is it relevant?
			if (j > 0)                               //no parentheses, watch out: only the next statement is conditional
				c.append(',')                        //no semicolon here
				;                                    //but here, is it part of the condition?

			c.append(a);                             //what again was c? and a?
		}
		return c.toString() + ')';                   //why do we add ')'?
	}

}
