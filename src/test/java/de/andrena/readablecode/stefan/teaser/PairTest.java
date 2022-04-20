package de.andrena.readablecode.stefan.teaser;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
public class PairTest {

	private final Pair p1 = new Pair(3, 4);
	private final Pair p2 = new Pair(1, 1);

	@Nested
	class testAdd1 {
		@Test
		void result() throws Exception {
			Pair result = p1.add1(p2);

			assertThat(result.left()).isEqualTo(4);
			assertThat(result.right()).isEqualTo(5);
		}

		
		@Test
		void p1() throws Exception {
			Pair result = p1.add1(p2);

			assertThat(p1).isEqualTo(new Pair(3, 4));
		}

		
		@Test
		void p2() throws Exception {
			Pair result = p1.add1(p2);

			assertThat(p2).isEqualTo(new Pair(1, 1));
		}
	}

	@Disabled
	@Nested
	class testAdd2 {
		@Test
		void result() throws Exception {
			Pair result = p1.add2(p2);

			assertThat(result.left()).isEqualTo(4);
			assertThat(result.right()).isEqualTo(5);
		}

		
		@Test
		void p1() throws Exception {
			Pair result = p1.add2(p2);

			assertThat(p1).isEqualTo(new Pair(3, 4));
		}

		
		@Test
		void p2() throws Exception {
			Pair result = p1.add2(p2);

			assertThat(p2).isEqualTo(new Pair(1, 1));
		}
	}

	@Disabled
	@Nested
	class testAdd3 {
		@Test
		void result() throws Exception {
			Pair result = p1.add3(p2);

			assertThat(result.left()).isEqualTo(4);
			assertThat(result.right()).isEqualTo(5);
		}

		
		@Test
		void p1() throws Exception {
			Pair result = p1.add3(p2);

			assertThat(p1).isEqualTo(new Pair(3, 4));
		}

		
		@Test
		void p2() throws Exception {
			Pair result = p1.add3(p2);

			assertThat(p2).isEqualTo(new Pair(1, 1));
		}
	}
}
