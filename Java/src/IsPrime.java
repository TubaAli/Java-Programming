import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the value of n : ");
		int n = sc.nextInt();

		int counter = 2;
		while (n >= counter * counter) {
			if (n % counter == 0) {
				System.out.println("not a prime");
				return;
			} else {
				counter++;
			}
		}
		System.out.println("is a prime");
	}
}
