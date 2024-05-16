package de.andrena.readablecode.examples;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class Naming {

	public static void main(String[] args) {
	}

	public void common() {
		for (int i = 0; i < 4; i++) {

		}
	}

	public void uncommon() {
		for (int index = 0; index < 4; index++) {

		}
	}

	public void notUnique(Employee employee) {
		var s = computeS(employee);

		System.out.println(s);
	}

	public void unique(Employee employee) {
		var salary = computeSalary(employee);

		System.out.println(salary);
	}

	public void tooDetailed(Employee employee) {
		var salaryOfEmployee = computeSalary(employee);

		System.out.println(salaryOfEmployee);
	}

	public void quiteShort(long id, String lang) {
		var entry = findByIdAndLang(id, lang);

		System.out.println(entry);
	}

	public void tooLong(long id, String lang, String collection, List<String> categories, Date date, long page, long size) {
		var entry = findByIdNotAndLangAndCollectionAndCategoryInAndDateBefore(
			id, lang, collection, categories, date, page, size);

		System.out.println(entry);
	}

	public void betterTechnicalAbstraction(long id, String lang, String collection, List<String> categories, Date date, long page, long size) {
		var entry = find()
			.filter(e -> e.id != id)
			.filter(e -> e.lang == lang)
			.filter(e -> e.collection == collection)
			.filter(e -> categories.contains(e.category))
			.filter(e -> e.date.before(date))
			.resolvePaged(page, size);

		System.out.println(entry);
	}

	public Entry findByIdAndLang(long id, String language) {
		return new Entry();
	}

	public Page<Entry> findByIdNotAndLangAndCollectionAndCategoryInAndDateBefore(long id, String language, String collection, List<String> categories, Date date, long page, long size) {
		return null;
	}

	public FluentQuery find() {
		return new FluentQuery();
	}

	private double computeS(Employee employee) {
		return Double.NaN;
	}

	private double computeSalary(Employee employee) {
		return Double.NaN;
	}

	interface HasSpines {
	}
	
	interface EatsInsects {
	}
	
	interface IsSmall {
	}

	interface Animal {
	}

	static class SmallAnimalThatHasSpikesEatsInsects implements Animal, IsSmall,HasSpines,EatsInsects {
		
	}

	static class Hedgehog implements Animal, IsSmall,HasSpines,EatsInsects {
		//knowing that Hedgehog Tenreks are also covered which is formally incorrect 
	}

	record Page<T>(T entry) {

	}

	record Entry(long id, String lang, String collection, String category, Date date) {

		public Entry() {
			this(0, null, null, null, null);
		}

	}

	private static class FluentQuery {

		public FluentQuery filter(Predicate<Entry> pred) {
			return this;
		}

		public Page<Entry> resolvePaged(long page, long size) {
			return null;
		}

	}

	private static class Employee {

	}
	
}
