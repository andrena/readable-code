package de.andrena.readablecode.part_0_teaser;


@SuppressWarnings("unused")
public class Adder {

	public static void main(String[] args) {
		final MyInteger x = new MyInteger(1);
		final MyInteger y = new MyInteger(20);
		final MyInteger z = new MyInteger(300);
		
		MyInteger sumXY = x.add(y);

		MyInteger sumXYZ = z.add(y);

		System.out.println(sumXYZ); //what do you expect?
		// 320
		// 321
		// 301
		
        // System.out.println(sumXY); //what do you expect?
		// 21
		// 20
		// 321

		//System.out.println(x); //what do you expect?
		//System.out.println(y); //what do you expect?
		//System.out.println(z); //what do you expect?
	}

}
