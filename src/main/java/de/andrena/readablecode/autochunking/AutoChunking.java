package de.andrena.readablecode.autochunking;

public class AutoChunking {
    
	/**
     * 12 chunks?
     * 
     * No! 2 chunks (System.out.println, parameters[i])  
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
