package de.andrena.readablecode.examples;

import java.util.Map;

public class CyclomaticComplexity {

	public static void main(String[] args) throws Exception {
		Eval evaluator = new Hard();

		System.out.println(evaluator.eval("(a+b)*c", Map.of("a", 1.0, "b", 2.0, "c", 3.0)));
		System.out.println(evaluator.eval("a*(b+c)", Map.of("a", 1.0, "b", 2.0, "c", 3.0)));

		evaluator = new Simplified();

		System.out.println(evaluator.eval("(a+b)*c", Map.of("a", 1.0, "b", 2.0, "c", 3.0)));
		System.out.println(evaluator.eval("a*(b+c)", Map.of("a", 1.0, "b", 2.0, "c", 3.0)));

	}

	private interface Eval {

		String eval(String text, Map<String, Double> arguments);

	}

	private static class Hard implements Eval {

		@Override
		public String eval(String text, Map<String, Double> args) {
			text = text.trim();
			int mulPos = text.indexOf('*');
			if (mulPos > 0) {
				String f1 = text.substring(0, mulPos).trim();
				String f2 = text.substring(mulPos + 1).trim();
				if (f1.startsWith("(")) {
					int closePos = f1.indexOf(')');
					if (closePos > 0) {
						f1 = f1.substring(1, closePos);
						int plusPos = f1.indexOf('+');
						if (plusPos > 0) {
							String s1_1 = f1.substring(0, plusPos).trim();
							String s1_2 = f1.substring(plusPos + 1).trim();
							return new StringBuilder()
								.append('(').append(args.get(s1_1)).append('+').append(args.get(s1_2)).append(')')
								.append('*')
								.append(args.get(f2))
								.append(" = ")
								.append(args.get(s1_1)).append('*').append(args.get(f2))
								.append('+')
								.append(args.get(s1_2)).append('*').append(args.get(f2))
								.toString();
						}
					}
				} else if (f2.startsWith("(")) {
					int closePos = f2.indexOf(')');
					if (closePos > 0) {
						f2 = f2.substring(1, closePos);
						int plusPos = f2.indexOf('+');
						if (plusPos > 0) {
							String s2_1 = f2.substring(0, plusPos).trim();
							String s2_2 = f2.substring(plusPos + 1).trim();
							return new StringBuilder()
								.append(args.get(f1))
								.append('*')
								.append('(').append(args.get(s2_1)).append('+').append(args.get(s2_2)).append(')')
								.append(" = ")
								.append(args.get(f1)).append('*').append(args.get(s2_1))
								.append('+')
								.append(args.get(f1)).append('*').append(args.get(s2_2))
								.toString();
						}
					}

				}
			}
			return null;
		}
	}

	private static class Simplified implements Eval {

		@Override
		public String eval(String text, Map<String, Double> args) {
			Expr expr = parseExpr(text.trim());
			if (!(expr instanceof Product product)) {
				return null;
			}
			if (product.factor1() instanceof Sum s1
				&& product.factor2() instanceof Var v2) {
				Sum transformed = new Sum(new Product(s1.summand1(), v2), new Product(s1.summand2(), v2));

				return new StringBuilder()
					.append(product.withArguments(args))
					.append(" = ")
					.append(transformed.withArguments(args))
					.toString();
			} else if (product.factor1() instanceof Var v1
				&& product.factor2() instanceof Sum s2) {
				Sum transformed = new Sum(new Product(v1, s2.summand1()), new Product(v1, s2.summand2()));

				return new StringBuilder()
					.append(product.withArguments(args))
					.append(" = ")
					.append(transformed.withArguments(args))
					.toString();
			}
			return null;
		}

		private Expr parseExpr(String text) {
			if (text.startsWith("(") && text.endsWith(")")) {
				return parseSum(text.substring(1, text.length() - 1).trim());
			} else if (text.length() == 1) {
				return new Var(text);
			} else {
				return parseProduct(text);
			}
		}

		private Expr parseSum(String text) {
			int plusPos = text.indexOf('+');
			if (plusPos < 0) {
				return parseProduct(text);
			} else {
				Expr s1 = parseProduct(text.substring(0, plusPos).trim());
				Expr s2 = parseProduct(text.substring(plusPos + 1).trim());
				return new Sum(s1, s2);
			}
		}

		private Expr parseProduct(String text) {
			int mulPos = text.indexOf('*');
			if (mulPos < 0) {
				return parseExpr(text);
			} else {
				Expr f1 = parseExpr(text.substring(0, mulPos).trim());
				Expr f2 = parseExpr(text.substring(mulPos + 1).trim());
				return new Product(f1, f2);
			}
		}

	}

	interface Expr {
		String withArguments(Map<String, Double> arguments);
	}

	record Product(Expr factor1, Expr factor2) implements Expr {

		@Override
		public String withArguments(Map<String, Double> arguments) {
			String f1 = factor1.withArguments(arguments);
			if (factor1 instanceof Sum) {
				f1 = '(' + f1 + ')';
			}
			String f2 = factor2.withArguments(arguments);
			if (factor2 instanceof Sum) {
				f2 = '(' + f2 + ')';
			}
			return f1
				+ "*"
				+ f2;
		}

	}

	record Sum(Expr summand1, Expr summand2) implements Expr {

		@Override
		public String withArguments(Map<String, Double> arguments) {
			return summand1.withArguments(arguments)
				+ "+"
				+ summand2.withArguments(arguments);
		}

	}

	record Var(String name) implements Expr {

		@Override
		public String withArguments(Map<String, Double> arguments) {
			return String.valueOf(arguments.get(name));
		}

	}
}
