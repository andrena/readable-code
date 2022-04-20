package de.andrena.readablecode.stefan.methods.b;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class PricingTest {

	@Test
	void testComputeTaxes() {
		Pricing pricing = new Pricing(new TaxingProperties()
			.withConsumerTax(0.19)
			.withSpecialTaxes(Map.of("Hand of Sulfuras", 0.0d, "Aged Brie", 0.2d)));

		ItemProperties itemProperties = new ItemProperties()
		.forItem("Aged Brie")
		.amount(2);
		CustomerProperties customerProperties = new CustomerProperties()
			.withTaxDiscount(0.1)
			.withTaxesPaid(22.4);
		pricing.computeTaxes(new Price(), itemProperties, customerProperties);
	}

}
