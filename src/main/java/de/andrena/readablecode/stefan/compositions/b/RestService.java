package de.andrena.readablecode.stefan.compositions.b;

public class RestService {

	private PricingSevice pricing;
	private TaxingService taxing;
	private ResponseFactory response;

	/**
	 * pricing -> taxing -> responding
	 */
	public Response generateOffer(Request req) {
		try {
			checkAuthorization(req);
			int amount = req.amount();
			String item = req.item();
			Price price = pricing.computePrice(item, amount);
			price = taxing.applyTaxes(price);
			return response.from(price);
		} catch (AuthorizationException e) {
			return response.unauthorized();
		}

	}

	private void checkAuthorization(Request req) throws AuthorizationException {
		// some code
	}
}
