import java.util.Scanner;

public class GCD {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		int r = 1;
		while(r != 0)
		{
			r = num1%num2;
			num1 = num2;
			num2 = r;
		}
		System.out.println(num1);
	}
}
