package de.andrena.readablecode.autochunking;

public class PrimitiveChunking {
    
	public static final int NUMBER = 8142;                      //4 chunks, recallable
	public static final String A_NUMBER = "0163897742";         //10 chunks, not recallable
	public static final String B_NUMBER = "0163-89 77 42";      //4 chunks, we use telephone number idiom, recallable

	public static final String CHARACTERS ="CFEG";              //4 chunks, recallable
	public static final String MANY_CHARACTERS = "GNUHCSARREB�";//12 chunks, not ecallable
	public static final String SAME_CHARACTERS = "�BERRASCHUNG";//1 chunk, we use german language, recallable
	
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