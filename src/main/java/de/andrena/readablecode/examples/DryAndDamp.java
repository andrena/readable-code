package de.andrena.readablecode.examples;

public class DryAndDamp {
	public static void main(String[] args) {
		Dry dry = new Dry();
		dry.moneyAfterOneDay();
		dry.moneyAfterSeveralDays();
		dry.foodAfterOneDay();
		dry.foodAfterSeveralDays();
		
		Damp damp = new Damp();
		damp.moneyAfterOneDay();
		damp.moneyAfterSeveralDays();
		damp.foodAfterOneDay();
		damp.foodAfterSeveralDays();
	}

	private static class Damp {
		void moneyAfterOneDay() {
			var resource = new Money(1);
			assert resource.price() == 1;
			resource.addDays(1);

			assert resource.price() == 1;
		}

		void moneyAfterSeveralDays() {
			var resource = new Money(1);
			assert resource.price() == 1;
			resource.addDays(100);

			assert resource.price() == 1;
		}

		void foodAfterOneDay() {
			var resource = new Food(1);
			assert resource.price() == 2;

			resource.addDays(1);

			assert resource.price() == 2;
		}

		void foodAfterSeveralDays() {
			var resource = new Food(1);
			assert resource.price() == 2;

			resource.addDays(11);

			assert resource.price() == 1;
		}
	}

	private static class Dry {
		void moneyAfterOneDay() {
			assertResourceValueAfterDays(new Money(1), 1, 1);
		}

		void moneyAfterSeveralDays() {
			assertResourceValueAfterDays(new Money(1), 1, 100);
		}

		void foodAfterOneDay() {
			assertResourceValueAfterDays(new Food(1), 2, 1);
		}

		void foodAfterSeveralDays() {
			assertResourceValueAfterDays(new Food(1), 1, 11);
		}

		private void assertResourceValueAfterDays(Resource resource, int value, int days) {
			resource.addDays(days);

			assert resource.price() == 1;
		}
	}

	private abstract static class Resource {
		private int amount;
		private int expiryIn;
		private int days;

		public Resource(int amount, int expiryIn) {
			this.amount = amount;
			this.expiryIn = expiryIn;
			this.days = expiryIn;
		}

		public int price() {
			if (days * 2 < expiryIn) {
				return (int) ((double) amount * 0.5 * singlePrice());
			} else {
				return amount * singlePrice();
			}
		}

		public void addDays(int days) {
			this.days -= days;
			if (this.days < 0) {
				this.days = 0;
			}
		}

		public abstract int singlePrice();

	}

	private static class Money extends Resource {

		public Money(int amount) {
			super(amount, 0);
		}

		@Override
		public int singlePrice() {
			return 1;
		}

	}

	private static class Food extends Resource {

		public Food(int amount) {
			super(amount, 20);
		}

		@Override
		public int singlePrice() {
			return 2;
		}

	}

}
