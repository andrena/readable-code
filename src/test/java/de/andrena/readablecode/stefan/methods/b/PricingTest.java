package de.andrena.readablecode.stefan.methods.b;

import java.util.Map;

import org.junit.jupiter.api.Test;

public class PricingTest {

	@Test
	void testComputeTaxes() {
		CustomerProperties customerProperties = new CustomerProperties()
			.withTaxDiscount(0.1)
			.withTaxesPaid(22.4);
		TaxingProperties taxingProperties = new TaxingProperties()
			.withConsumerTax(0.19)
			.withSpecialTaxes(Map.of("Hand of Sulfuras", 0.0d, "Aged Brie", 0.2d));
		Pricing pricing = new Pricing(taxingProperties, customerProperties);

		ItemProperties itemProperties = new ItemProperties()
			.forItem("Aged Brie")
			.amount(2);

		pricing.computeTaxes(new Price(42.0), itemProperties);
	}

}
