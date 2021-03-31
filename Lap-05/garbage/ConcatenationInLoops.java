package hust.soict.hedspi.garbage;

import java.util.Random;

public class ConcatenationInLoops {
	public static void main(String[] args) {
		Random r = new Random(123);
		long start = System.currentTimeMillis();
		@SuppressWarnings("unused")
		String s = "";
		for(int i = 0; i < 65536; i++) 
			s += r.nextInt(2);
		System.out.println(System.currentTimeMillis() - start); //This prints roughly 4500.
			
		r = new Random(123);
		start = System.currentTimeMillis();
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < 65636 ; i++)
			sBuilder.append(r.nextInt(2));
		s = sBuilder.toString();
		System.out.println(System.currentTimeMillis() - start); //This prints 5
	
	}
}
