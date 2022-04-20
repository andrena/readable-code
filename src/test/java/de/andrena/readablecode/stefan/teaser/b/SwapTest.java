package de.andrena.readablecode.stefan.teaser.b;

import static de.andrena.readablecode.stefan.teaser.b.Swap.swap;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SwapTest {
	@Test
	void testSwap() throws Exception {
		Pair<String> pair = new Pair<>("A", "B");

		Pair<String> swapped = swap(pair);

		assertThat(swapped.left()).isEqualTo("B");
		assertThat(swapped.right()).isEqualTo("A");

		//assertThat(pair.left()).isEqualTo("");
		//assertThat(pair.right()).isEqualTo("");
	}
}