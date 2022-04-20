package de.andrena.readablecode.stefan.compositions.b;

public class RestService {

	/** Magic Complexity = 1 (this class) */
	private PricingSevice pricing;    //+1
	private TaxingService taxing;     //+1
	private ResponseFactory response; //+1
	/**                                = 4*/
	
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
