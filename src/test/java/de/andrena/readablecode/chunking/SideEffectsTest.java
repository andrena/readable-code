package de.andrena.readablecode.chunking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SideEffectsTest {

	private SideEffects sideEffects;

	@BeforeEach
	void before() throws Exception {
		sideEffects = new SideEffects(2);
	}

	@Test
	void testPureFunctional() {
		int result = sideEffects.pureFunctional(1, 2); // 1 + 2 
		/* memory contains
		 *  call of purefunctional +1
		 *  operand 1              +1
		 *  operand 2              +1
		 *  -------------------------
		 *  chunks                  3
		 */
		assertThat(result).isEqualTo(3);
	}

	@Test
	void testProperOO() {
		int result = sideEffects.properOO(1, 2); // (1+2) * sideEffects.scalingFactor 
		/* memory contains
		 *  the sideEffects object  +1
		 *  call of properOO        +1
		 *  operand 1               +1
		 *  operand 2               +1
		 *  --------------------------
		 *  chunks                   4
		 */
		assertThat(result).isEqualTo(6);
	}

	@Test
	void testMutableOO() {
		sideEffects.mutableOO(3); 
		/* memory contains
		 *  the sideEffects object before mutation +1
		 *  call of mutableOO                      +1
		 *  operand 3                              +1
		 *  the sideEffects object after mutation  +1
		 *  -----------------------------------------
		 *  chunks                                  4
		 */
		assertThat(sideEffects.scale(1)).isEqualTo(3);
	}

	@Test
	void testComplexMutableOO() {
		SideEffects arg = new SideEffects(1);
		SideEffects result = sideEffects.complexMutableOO(arg); 
		/* memory contains
		 *  the sideEffects object before mutation +1
		 *  call of complexMutableOO               +1
		 *  operand arg                            +1
		 *  the sideEffects object after mutation  +1
		 *  the result is an alias of sideEffects  +1
		 *  -----------------------------------------
		 *  chunks                                  5
		 */
		assertThat(sideEffects.scale(1)).isEqualTo(3);
		assertThat(result.scale(1)).isEqualTo(3);
		assertThat(arg.scale(1)).isEqualTo(1);
		
		/* but it is quite readable!?
		 * - only because most of us omit the 5th chunk
		 * - mostly this is not a problem because we either use one or the other alias but not both
		 */ 
	}

	@Test
	void testUnconventionalMutableOO() {
		SideEffects arg = new SideEffects(1);
		SideEffects result = sideEffects.unconventionalMutableOO(arg); 
		/* memory contains
		 *  the sideEffects object before mutation +1
		 *  call of unconventionalMutableOO        +1
		 *  operand arg                            +1
		 *  arg after mutation                     +1
		 *  the result is an alias of arg          +1
		 *  -----------------------------------------
		 *  chunks                                  5
		 */
		
		assertThat(sideEffects.scale(1)).isEqualTo(2);
		assertThat(result.scale(1)).isEqualTo(3);
		assertThat(arg.scale(1)).isEqualTo(3); 
		
		// readable? then check this:
		
		result.mutableOO(0);
		
		assertThat(arg.scale(1)).isEqualTo(0);
		
		/* why is this surprising
		 * - only because most of us omit the 5th chunk
		 * - and this reminds us to always keep in mind that arg and result are aliases
		 */
	}

}
