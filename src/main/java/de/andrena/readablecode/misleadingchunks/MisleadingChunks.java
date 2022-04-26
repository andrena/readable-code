package de.andrena.readablecode.misleadingchunks;

import de.andrena.readablecode.part_0_teaser.MyInteger;

public class MisleadingChunks {

	/**
	 * review @see Adder
	 */
	public static void main(String[] args) {
		final MyInteger x = new MyInteger(1);
		final MyInteger y = new MyInteger(20);
		final MyInteger z = new MyInteger(300);
		
		MyInteger sumXY = x.add(y);             // we see the chunk sumXY = 1 + 20
		                                        // but beyond our knowledge there is y = 1 + 20

		MyInteger sumXYZ = z.add(y);            // we see the chunk sumXYZ = 300 + 20 
		                                        // and are surprised by sumXYZ = 300 + 20 + 1 (because y = 1 + 20 instead y = 20)
												// and beyond our knowledge there is y = 1 + 20 + 300 

		System.out.println(sumXYZ);             // 321
		
        System.out.println(sumXY);              // 321

		System.out.println(x);                  //   1
		System.out.println(y);                  // 321 surprisingly because two steps where beyond our knowledge/assumptions
		System.out.println(z);                  // 300
	}

	
}
