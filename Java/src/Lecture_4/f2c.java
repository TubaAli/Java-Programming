package Lecture_4;

public class f2c {

	public static void main(String[] args) {
		int f = 0;
		int c = 0;
		while (f <= 300) {
			c = (int) ((5.0 / 9) * (f - 32));
			System.out.println(f + " " + c);
			// System.out.println(f +' '+ c); //single quotes represent
			// characters
			f += 20;
		}
	}
}
