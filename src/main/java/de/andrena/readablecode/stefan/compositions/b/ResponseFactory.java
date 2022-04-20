package de.andrena.readablecode.stefan.compositions.b;

public interface ResponseFactory {

	Response from(Price price);

	Response unauthorized();

}
