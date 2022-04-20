package de.andrena.readablecode.stefan.compositions.a;

public class RestService {

	/** Magic Complexity = 1 (this class) */
	private AuthenticationService auth;              // +1
	private RequestExtractor requests;               // +1
	private DiscountSevice discounting;              // +1
	private PricingSevice pricing;                   // +1
	private ConsumerTaxingService consumerTaxing;    // +1
	private SpecialTaxingService specialTaxing;      // +1
	private ResponseFactory response;                // +1
	/**                                               = 8*/
	
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
