package de.andrena.readablecode.expressions.refactored;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class AggregatorMain {
	private static final String SUM = "sum";
	private static final String PRODUCT = "product";

	public static void main(String[] args) {
		String operation = args[0];

		List<Long> arguments = Arrays.stream(args)
			.skip(1)
			.map(Long::valueOf)
			.collect(toList());

		Aggregator aggregator = new Aggregator();

		for (Long argument : arguments) {
			aggregator.accept(argument);
		}

		if (operation.equals(SUM)) { // und geben je nach Operation einen anderen Text aus
			System.out.println("Sum = " + aggregator.sum());
		} else if (operation.equals(PRODUCT)) {
			System.out.println("Product = " + aggregator.product());
		}
	}
}

class Aggregator {
	private List<Long> arguments;

	public Aggregator accept(Long argument) {
		arguments.add(argument);
		return this;
	}

	public long sum() {
		return arguments.stream()
			.mapToLong(Long::longValue)
			.sum();
	}

	public long product() {
		return arguments.stream()
			.mapToLong(Long::longValue)
			.sum();
	}

}
