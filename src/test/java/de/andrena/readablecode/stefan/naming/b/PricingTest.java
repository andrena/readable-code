package de.andrena.readablecode.stefan.naming.b;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class PricingTest {

	@Test
	void testComputePrice() {
		Pricing pricing = new Pricing(0.19);
		
		assertThat(pricing.computePrice(100, 9.99).netValue()).isEqualTo(new BigDecimal("839.50"));
	}

}
