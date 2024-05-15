package de.andrena.readablecode.examples;

import static java.util.stream.Collectors.joining;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class LiveVariablesComplexity {

	public static void main(String[] args) throws Exception {
		Register register = new ConciseRegister(Map.of(
			"Backstage Pass", "50.00",
			"Aged Brie", "4.99",
			"Hand of Sulfuras", "9999999.00",
			"Dexterity West +5", "400.00"));

		System.out.println(register.bill("2 Backstage Pass", "3 Aged Brie", "1 Dexterity West +5"));

		System.out.println();
		
		register = new ComplexRegister(Map.of(
			"Backstage Pass", "50.00",
			"Aged Brie", "4.99",
			"Hand of Sulfuras", "9999999.00",
			"Dexterity West +5", "400.00"));

		System.out.println(register.bill("2 Backstage Pass", "3 Aged Brie", "1 Dexterity West +5"));
}

	private interface Register {

		String bill(String... items) throws ParseException;

	}

	private static class ComplexRegister implements Register {
		private Map<String, String> prices;

		public ComplexRegister(Map<String, String> prices) {
			this.prices = prices;
		}

		@Override
		public String bill(String... items) throws ParseException {
			DecimalFormat decimalFormat = decimalFormat();

			var finalPrice = new BigDecimal(0);
			var tokens = new ArrayList<String>();

			var valueAdded = new BigDecimal(0);

			for (var item : items) {
				var parsed = item.split("\\s", 2);
				var count = Integer.parseInt(parsed[0]);
				var type = parsed[1];

				var priceString = prices.get(type);
				
				var padding = paddingFor(type, 20);
				
				var price = (BigDecimal) decimalFormat.parse(priceString);
				var sumPrice = price.multiply(BigDecimal.valueOf(count));

				//Live Variables = {finalPrice, tokens, valueAdded, parsed, count, priceString, price, sumPrice, padding}
				//Number of Live Variables = 9
				tokens.add(parsed[1] + padding + "\t" + parsed[0] + "\ta " + priceString + paddingFor(priceString, 10) + "\t= " + sumPrice);

				finalPrice = finalPrice.add(sumPrice);
				valueAdded = valueAdded.add(sumPrice.multiply(BigDecimal.valueOf(0.19)));
			}
			return tokens.stream().collect(joining("\n")) + "\n------------\n" + finalPrice + " + " + valueAdded + " (value added tax)";
		}

		private static String paddingFor(String type, int i) {
			var alignmentTemplate = new char[i];
			Arrays.fill(alignmentTemplate, ' ');
			var padding = new String(Arrays.copyOf(alignmentTemplate, alignmentTemplate.length - type.length()));
			return padding;
		}

	}

	private static class ConciseRegister implements Register {
		private Map<String, String> prices;

		public ConciseRegister(Map<String, String> prices) {
			this.prices = prices;
		}

		@Override
		public String bill(String... items) throws ParseException {
			DecimalFormat decimalFormat = decimalFormat();

			var finalPrice = new BigDecimal(0);
			var tokens = new ArrayList<String>();

			for (var item : items) {
				var line = new BillLine();
				
				var parsed = item.split("\\s", 2);
				
				var count = Integer.parseInt(parsed[0]);
				line.setCount(count);
				
				var type = parsed[1];
				line.setType(type);

				var priceString = prices.get(type);
				
				var price = (BigDecimal) decimalFormat.parse(priceString);
				line.setPrice(price);
				
				var sumPrice = price.multiply(BigDecimal.valueOf(count));
				line.setSum(sumPrice);

				//Live Variables = {finalPrice, tokens, line}
				//Number of Live Variables = 3
				tokens.add(line.toString());

				finalPrice = finalPrice.add(line.sumPrice());
			}
			var valueAdded = finalPrice.multiply(BigDecimal.valueOf(0.19));
			return tokens.stream().collect(joining("\n")) + "\n------------\n" + finalPrice + " + " + valueAdded + " (value added tax)";
		}

	}
	
	private static class BillLine {

		private int count;
		private String type;
		private BigDecimal price;
		private BigDecimal sumPrice;

		public void setCount(int count) {
			this.count = count;
		}

		public BigDecimal sumPrice() {
			return sumPrice;
		}

		public void setSum(BigDecimal sumPrice) {
			this.sumPrice = sumPrice;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		private String pad(Object o, int i) {
			String padded = o.toString();
			while (padded.length() < i) {
				padded = padded + " ";
			}
			return padded;
		}
		
		@Override
		public String toString() {
			return pad(type,20) + "\t" + count + "\ta " + pad(price, 10) + "\t= " + sumPrice;
		}

	}

	private static DecimalFormat decimalFormat() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setGroupingSeparator(',');
		symbols.setDecimalSeparator('.');
		String pattern = "#,##0.0#";
		DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
		decimalFormat.setParseBigDecimal(true);
		return decimalFormat;
	}

}
