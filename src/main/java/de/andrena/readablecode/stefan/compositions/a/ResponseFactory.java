package de.andrena.readablecode.stefan.compositions.a;

public interface ResponseFactory {

	Response from(Price price);

	Response unauthorized();

}
