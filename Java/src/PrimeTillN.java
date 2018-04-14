import java.util.Scanner;

public class PrimeTillN {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		System.out.println("Enter the value of n : ");
		int n = sc.nextInt();

		int numToCheck = 2;
		while (numToCheck <= n) {
			boolean isPrime1 = true;
			int counter = 2;
			while (counter * counter <= numToCheck) {
				if (numToCheck % counter == 0) {
					isPrime1 = false;
					break;
				} else
					counter++;
			}

			if (isPrime1 == true)
				System.out.println(numToCheck);

			numToCheck++;
		}

	}
}