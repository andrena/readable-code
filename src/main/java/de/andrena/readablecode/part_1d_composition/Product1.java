package de.andrena.readablecode.part_1d_composition;

import java.math.BigDecimal;
import java.util.List;

/**
 * 7 chunks = hard to recall
 */
public record Product1(int id, String title, String description, BigDecimal price, int available, List<String> comments, List<Integer> stars) {
}
