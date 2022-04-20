package de.andrena.readablecode.peter;

public class Magic4Examples_MethodParameters {
    /**
     * Recommended by Robert C. Martin ("Clean Code")
     */
    public void bestIsNoParameters() {
        // 1 Fact for this
        // 1 Fact for the method name
    }

    /**
     * Still easy to remember.
     */
    public void oneParameter(String parameter1) {
        System.out.println(parameter1);
        // ...
    }

    /**
     * Can handle that, too.
     */
    public void twoParameters(String parameter1, boolean parameter2) {
        System.out.println(parameter1);
        System.out.println(parameter2);
        // ...
    }

    /**
     * It gets harder...
     */
    public void threeParameters(String parameter1, boolean parameter2, int parameter3) {
        System.out.println(parameter1);
        System.out.println(parameter2);
        System.out.println(parameter3);
        // ...
    }

    /**
     * Okay, I'm confused.
     */
    public void fourParameters(String parameter1, boolean parameter2, int parameter3, double parameter4) {
        System.out.println(parameter1);
        System.out.println(parameter2);
        System.out.println(parameter3);
        System.out.println(parameter4);
        // ...
    }

    /**
     * Too much!
     */
    public void fiveParameters(String parameter1, boolean parameter2, int parameter3, double parameter4, String parameter5) {
        System.out.println(parameter1);
        System.out.println(parameter2);
        System.out.println(parameter3);
        System.out.println(parameter4);
        System.out.println(parameter5);
        // ...
    }

    private void usages() {
        this.bestIsNoParameters();

        this.oneParameter("https://someurl.com");

        this.twoParameters("https://someurl.com", false);

        this.threeParameters("https://someurl.com", false, 42);

        this.fourParameters("https://someurl.com", false, 42, 3.141);

        this.fiveParameters("https://someurl.com", false, 42, 3.141, "Too much!");
    }
}
