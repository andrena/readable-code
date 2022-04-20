package de.andrena.readablecode.stefan.codeblocks.b;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class InterpreterTest {

	@Test
	void testSwap() {
		Interpreter interpreter = new Interpreter();
		interpreter.push("A");
		interpreter.push("B");
		
		interpreter.swap();
		
		assertThat(interpreter.pop()).isEqualTo("A");
		assertThat(interpreter.pop()).isEqualTo("B");
	}

}
