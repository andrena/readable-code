package de.andrena.readablecode.badcode;

import java.time.Instant;

public record RawItem(
	String name,
	Instant timestamp,
	boolean visible) {

}
