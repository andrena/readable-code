package de.andrena.readablecode.grouping;

public class AutoChunking {
    
	/**
     * 13 chunks?
     * 
     * No! 3 chunks (System.out.println, parameters[i], 13)  
     */
    public void autoChunking(String[] parameters) {
        System.out.println(parameters[0]);
        System.out.println(parameters[1]);
        System.out.println(parameters[2]);
        System.out.println(parameters[3]);
        System.out.println(parameters[4]);
        System.out.println(parameters[5]);
        System.out.println(parameters[6]);
        System.out.println(parameters[7]);
        System.out.println(parameters[8]);
        System.out.println(parameters[9]);
        System.out.println(parameters[10]);
        System.out.println(parameters[11]);
        System.out.println(parameters[12]);
    }

}
