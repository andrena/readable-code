package de.andrena.readablecode.examples;

public class NumberOfArguments {
	
	public void quiteComprehensible() {
		var trader1 = new Trader();
		var trader2 = new Trader();
		var wheat = "wheat";
		
		trader1.trade(wheat, trader2);
	}
	
	public void quiteHard() {
		var trader1 = new Trader();
		var trader2 = new Trader();

		var wheat = "wheat";
		var money = "money";

		trader1.trade(1, wheat, 2, money, trader2);
	}
	
	public void hardlyComprehensible() {
		Trader trader = new Trader();

		var m = "wheat";
		var n = "money";
		var t = new Trader();

		trader.trade(1, 2, t, m, n);
	}
	
	public static class Trader {

		public void trade(String resource, Trader with) {
		}
		
		public void trade(int amount, String resource, int paymentAmount, String paymentUnit, Trader with) {
		}
		
		public void trade(int amount, int paymentAmount, Trader with, String resource, String paymentUnit) {
		}
	}
}
