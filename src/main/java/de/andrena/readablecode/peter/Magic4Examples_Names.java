package de.andrena.readablecode.peter;

public class Magic4Examples_Names {

    /**
     * From the context, it is clear that the names are fruit.
     */
    public void oneFact() {
        String[] names = {"limes", "oranges", "mandarins", "grapefruits", "pomelos"};

        System.out.println("The most delicious fruit is " + names[0]);
    }

    /**
     * Besides fruit, there are also vegetables.
     */
    public void twoFacts() {
        String[] fruitNames = {"limes", "oranges", "mandarins", "grapefruits", "pomelos"};
        String[] vegetableNames = {"cucumber", "carrot", "paprika", "zucchini"};

        System.out.println("I like " + fruitNames[2] + "the most. " + vegetableNames[0] + " is not my favorite.");
    }

    /**
     * There are several types of fruit and we need to be precise.
     */
    public void threeFacts() {
        String[] citrusFruitNames = {"limes", "oranges", "mandarins"};
        String[] berryFruitNames = {"strawberry"};
        String[] kernobstFruitNames = {"apple", "pear"};

        // ...
    }

    /**
     * This is gross - please do not do this!
     */
    public void tooManyFacts() {
        String[] listOfLemonsLimesOrangesMandarinsGrapefruitsPomelos = {"lemons", "limes", "oranges", "mandarins", "grapefruits", "pomelos"};

        // ...
    }

}
