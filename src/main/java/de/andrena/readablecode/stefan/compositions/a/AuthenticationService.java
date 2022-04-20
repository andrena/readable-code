package de.andrena.readablecode.stefan.compositions.a;

public interface AuthenticationService {

	void checkAuthorization(Request req) throws AuthorizationException;

}
