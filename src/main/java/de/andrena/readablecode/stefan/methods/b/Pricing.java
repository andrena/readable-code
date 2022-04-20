package de.andrena.readablecode.stefan.methods.b;

import static de.andrena.readablecode.Use.use;

public class Pricing {
	private TaxingProperties taxingProperties;

	public Pricing(TaxingProperties taxingProperties) {
		this.taxingProperties = taxingProperties;
	}

	public Price computeTaxes(Price price, ItemProperties itemProperties, CustomerProperties customerProperties) {
		use(taxingProperties);
		return null;
	}
}
