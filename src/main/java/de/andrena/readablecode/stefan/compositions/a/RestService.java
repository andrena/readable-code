package de.andrena.readablecode.stefan.compositions.a;

public class RestService {

	private DiscountSevice discounting;
	private PricingSevice pricing;
	private ConsumerTaxingService consumerTaxing;
	private SpecialTaxingService specialTaxing;
	private ResponseFactory response;

	/**
	 * which dependency is to be applied in which sequence?
	 * do you remember all 5 dependencies?
	 */
	public Response generateOffer(Request req) {
		try {
			checkAuthorization(req);
			int amount = req.amount();
			String item = req.item();
			Price price = pricing.computePrice(item, amount);
			price = discounting.applyDiscounts(item, amount, price);
			price = specialTaxing.applyTaxes(item, amount, price);
			price = consumerTaxing.applyTaxes(price);
			return response.from(price);
		} catch (AuthorizationException e) {
			return response.unauthorized();
		}

	}

	private void checkAuthorization(Request req) throws AuthorizationException {
		// some code
	}
}
