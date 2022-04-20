package de.andrena.readablecode.stefan.methods.b;

import static de.andrena.readablecode.Use.use;

public class Pricing {
	private TaxingProperties taxingProperties;
	private CustomerProperties customerProperties;

	public Pricing(TaxingProperties taxingProperties, CustomerProperties customerProperties) {
		this.taxingProperties = taxingProperties;
		this.customerProperties = customerProperties;
	}

	/**
	 * Magic Complexity for client
	 * - uses this object        + 1
	 * - computes Taxes          + 1
	 * - uses price              + 1
	 * - uses item Properties    + 1
	 */
	public Price computeTaxes(Price price, ItemProperties itemProperties) {
		use(taxingProperties);
		use(customerProperties);
		return null;
	}
}
