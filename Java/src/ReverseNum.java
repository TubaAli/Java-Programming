import java.util.Scanner;

public class ReverseNum {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter the number to be reversed : ");
		int num = sc.nextInt();

		while (num != 0) {
			int r = num % 10;
			int q = num / 10;
			System.out.print(r);
			num = q;
		}
	}

}
