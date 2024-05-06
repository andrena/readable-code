package de.andrena.readablecode.examples;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;

public class MutableState {

	public static void main(String[] args) {
		MutableState mutableState = new MutableState();

		mutableState.hardlyComprehensible();
	}

	public void avoidThis() {
		var s = List.of(
			new Wheat(2),
			new Wood(5),
			new Clay(3))
			.toString();
		s = s.replace(",", "\n");
		s = s.replaceAll(".", "-");

		System.out.println(s);
	}

	public void betterThis() {
		var list = List.of(
			new Wheat(2),
			new Wood(5),
			new Clay(3));
		var listString = list.toString();
		var separatedByNewline = listString
			.replace(",", "\n");
		var withoutDots = separatedByNewline
			.replaceAll(".", "-");

		System.out.println(withoutDots);
	}

	public void wellKnown() {
		var resources = new Resources();
		resources.add(new Wheat(2));
		resources.add(new Wood(5));
		resources.add(new Clay(3));

		System.out.println(resources);
	}

	public void quiteHard() {
		var resources = new Resources();
		resources.add(new Wheat(2));
		resources.add(new Wood(5));
		resources.add(new Clay(3));

		resources.remove(new Wheat(2));
		resources.remove(new Wood(3));

		System.out.println(resources);
	}

	public void hardlyComprehensible() {
		Wheat wheat2 = new Wheat(2);
		Wood wood5 = new Wood(5);
		Clay clay3 = new Clay(3);

		var resources = new Resources();
		resources.add(wheat2);
		resources.add(wood5);
		resources.add(clay3);

		doSomesting(wood5);

		System.out.println(resources);
	}

	private void doSomesting(Resource r) {
		r.amount *= 5;
	}

	private static class Resources {

		private List<Resource> resources;

		public Resources() {
			this.resources = new ArrayList<>();
		}

		public void add(Resource resource) {
			resources.add(resource);
		}

		public void remove(Resource resource) {
			resources.stream()
				.filter(r -> r.getClass() == resource.getClass())
				.findFirst()
				.map(r -> r.amount -= resource.amount)
				.orElseThrow();
		}

		@Override
		public String toString() {
			return resources.stream()
				.map(Object::toString)
				.collect(joining(","));
		}
	}

	private static class Resource {
		public int amount;

		public Resource(int amount) {
			this.amount = amount;
		}

		@Override
		public String toString() {
			return amount + "." + getClass().getSimpleName();
		}

	}

	private static class Wheat extends Resource {

		public Wheat(int amount) {
			super(amount);
		}

	}

	private static class Clay extends Resource {

		public Clay(int amount) {
			super(amount);
		}

	}

	private static class Wood extends Resource {

		public Wood(int amount) {
			super(amount);
		}

	}

}
