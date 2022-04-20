package de.andrena.readablecode.stefan.compositions.a;

public class RestService {

	private AuthenticationService auth;
	private RequestExtractor requests;
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
			auth.checkAuthorization(req);
			int amount = requests.extractAmount(req);
			String item = requests.extractItem(req);
			Price price = pricing.computePrice(item, amount);
			price = discounting.applyDiscounts(item, amount, price);
			price = specialTaxing.applyTaxes(item, amount, price);
			price = consumerTaxing.applyTaxes(price);
			return response.from(price);
		} catch (AuthorizationException e) {
			return response.unauthorized();
		}

	}

}
