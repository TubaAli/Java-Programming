import java.util.Scanner;

public class AllFibTill {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();

		int num1 = 0;
		System.out.print(num1+" ");
		int num2 = 1;
		System.out.print(num2+" ");

		int i = 1, num3 = 0;
		while (i < n) {
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			System.out.print(num3+" ");
			i=num3;
		}
	}

}