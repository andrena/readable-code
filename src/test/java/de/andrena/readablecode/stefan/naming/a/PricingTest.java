package de.andrena.readablecode.stefan.naming.a;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class PricingTest {

	@Test
	void testComputeGrossValueAndSubstractConsumerTax() {
		Pricing pricing = new Pricing(0.19);
		
		assertThat(pricing.computeGrossValueAndSubstractConsumerTax(100, 9.99)).isEqualTo(new BigDecimal("839.50"));
	}

}
