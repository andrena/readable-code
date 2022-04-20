package de.andrena.readablecode.stefan.methods.a;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class PricingTest {

	@Test
	void testComputeTaxes() {
		Pricing pricing = new Pricing();

		pricing.computeTaxes(new Price(), 2, "Aged Brie", 0.19, Map.of("Hand of Sulfuras", 0.0d, "Aged Brie", 0.2d), 0.1, 22.4);
	}

}
