package de.andrena.readablecode.composition;

import java.math.BigDecimal;
import java.util.List;

/**
 * 4 chunks = recallable
 */
public record Product2(int id, Label label, Supply supply, UserFeedback userFeedback) {

	public static record Supply(BigDecimal price, int available) {
	}

	public static record Label(String title, String description) {
	}

	public static record UserFeedback(List<String> comments, List<Integer> stars) {
	}

}
