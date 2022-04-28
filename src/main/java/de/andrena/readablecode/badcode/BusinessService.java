package de.andrena.readablecode.badcode;

import static java.util.stream.Collectors.toList;

import java.time.Instant;
import java.util.List;

public class BusinessService {

	public List<Item> computeEntriesFilteredAndSorted(
		List<RawItem> rawEntries, 
		Instant now, 
		boolean v, 
		String field, 
		boolean order) {
		return rawEntries.stream()
			.map(Item::from)
			.filter(i -> i.after(now))
			.filter(i -> !v | i.isVisible())
			.sorted((i1, i2) -> {
				int sign = order
					? 1
					: 0;
				if (field.equals("name")) {
					return sign * i1.getName()
						.compareTo(i2.getName());
				} else if (field.equals("time")) {
					return sign * i1.getTimestamp()
						.compareTo(i2.getTimestamp());
				} else {
					return 0;
				}
			})
			.collect(toList());
	}
}
