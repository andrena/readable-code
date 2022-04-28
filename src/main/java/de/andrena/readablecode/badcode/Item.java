package de.andrena.readablecode.badcode;

import java.time.Instant;

public class Item {

	private String name;
	private Instant timestamp;
	private boolean visible;

	public static Item from(RawItem rawItem) {
		Item item = new Item();
		item.name = rawItem.name();
		item.timestamp = rawItem.timestamp();
		item.visible = rawItem.visible();
		return item;
	}

	public String getName() {
		return name;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public boolean isVisible() {
		return visible;
	}

	public boolean after(Instant now) {
		return timestamp.isAfter(now);
	}

}
