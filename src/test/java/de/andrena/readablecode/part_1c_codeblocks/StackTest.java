package de.andrena.readablecode.part_1c_codeblocks;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StackTest {

	@Test
	void testSwap() {
		Stack interpreter = new Stack();
		interpreter.push("A");
		interpreter.push("B");
		
		interpreter.swap();
		
		assertThat(interpreter.pop()).isEqualTo("A");
		assertThat(interpreter.pop()).isEqualTo("B");
	}

}
