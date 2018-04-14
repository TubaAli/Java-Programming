
public class LargestOfThree {

	public static void main(String[] args) {
		int a = 10;
		int b = 15;
		int c = 5;
		
		System.out.println(Math.max(Math.max(a, b), c));
		
		if (a >= b && a >= c) {
			System.out.println(a);
		} else {
			if (b >= a && b >= c) {
				System.out.println(b);
			} else {
				System.out.println(c);
			}
		}
	}
}
