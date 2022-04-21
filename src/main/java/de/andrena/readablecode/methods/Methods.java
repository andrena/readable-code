package de.andrena.readablecode.methods;

public class Methods {
    /**
     * Two chunks (this,bestIsNoParameters) = Recommended by Robert C. Martin ("Clean Code")
     */
    public void bestIsNoParameters() {
        // 1 Fact for this
        // 1 Fact for the method name
    }

    /**
     * Three chunks (this, oneParameter, parameter1) = Still easy to remember.
     */
    public void oneParameter(String parameter1) {
        System.out.println(parameter1);
        // ...
    }

    /**
     * Four chunks (this, twoParameter, parameter1, parameter2) = Can handle that, too.
     */
    public void twoParameters(String parameter1, boolean parameter2) {
        System.out.println(parameter1);
        System.out.println(parameter2);
        // ...
    }

    /**
     * Five chunks (this, twoParameter, parameter1, parameter2, parameter3) = It gets harder... we feel the limit
     */
    public void threeParameters(String parameter1, boolean parameter2, int parameter3) {
        System.out.println(parameter1);
        System.out.println(parameter2);
        System.out.println(parameter3);
        // ...
    }

    /**
     * Six chunks (...) = I'm confused.
     */
    public void fourParameters(String parameter1, boolean parameter2, int parameter3, double parameter4) {
        System.out.println(parameter1);
        System.out.println(parameter2);
        System.out.println(parameter3);
        System.out.println(parameter4);
        // ...
    }

    /**
     * Seven chunks (...) = Too much!
     */
    public void fiveParameters(String parameter1, boolean parameter2, int parameter3, double parameter4, String parameter5) {
        System.out.println(parameter1);
        System.out.println(parameter2);
        System.out.println(parameter3);
        System.out.println(parameter4);
        System.out.println(parameter5);
        // ...
    }

    public void usages() {
        this.bestIsNoParameters();

        this.oneParameter("https://easy-to-recall.com");

        this.twoParameters("https://still-easy-to-recall.com", false);

        this.threeParameters("https://ok-to-recall.com", false, 42);

        this.fourParameters("https://hard-to-recall.com", false, 42, 3.141);

        this.fiveParameters("https://only-trained-recall-this.com", false, 42, 3.141, "Too much!");
    }
}
