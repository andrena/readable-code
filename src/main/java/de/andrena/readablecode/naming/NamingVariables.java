package de.andrena.readablecode.naming;

import static de.andrena.readablecode.Use.use;

import java.util.List;

public class NamingVariables {

	/**
	 * From the context, it is clear that the names are food.
	 */
	public void oneChunk() {
		List<String> list = List.of("limes", "oranges", "mandarins", "strawberry", "apple", "carrot", "zucchini", "meat", "mutton");

		for (String item : List.of("oranges", "knife")) {
			System.out.println(item + " is " + (list.contains(item) ? "food" : " not food"));
		}
	}

	/**
	 * Besides fruit, there are also vegetables.
	 */
	public void twoChunks() {
		List<String> fruitList = List.of("limes", "oranges", "mandarins", "grapefruits", "pomelos");
		List<String> vegetableList = List.of("cucumber", "carrot", "paprika", "zucchini");

		for (String item : List.of("oranges", "carrot", "knife")) {
			if (fruitList.contains(item)) {
				System.out.println(item + " is a fruit");
			} else if (vegetableList.contains(item)) {
				System.out.println(item + " is a vegetable");
			} else {
				System.out.println(item + " is neither fruit nor vegetable");
			}
		}
	}

	/**
	 * There are several types of fruit and we need to be precise.
	 */
	public void threeChunks() {
		List<String> citrusFruitList = List.of("limes", "oranges", "mandarins" );
		List<String> berryFruitList = List.of( "strawberry" );
		List<String> pomaceousFruitList = List.of( "apple", "pear" );

		use(citrusFruitList, berryFruitList, pomaceousFruitList);
	}

	/**
	 * This may me precise, but is not readable - better sacrifice the precision for readability
	 */
	public void tooManyChunks() {
		List<String> listOfLemonsLimesOrangesMandarinsGrapefruitsPomelos = List.of("lemons", "limes", "oranges", "mandarins", "grapefruits", "pomelos" );
		//the brain reads listOfAnythingOfMinorInterest
		//and every time you want to recall the information you have to reread the name
		use(listOfLemonsLimesOrangesMandarinsGrapefruitsPomelos);
	}

}
