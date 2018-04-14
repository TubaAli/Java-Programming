import java.util.Scanner;

public class SumToN {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		System.out.println("Enter the value of n = ");
		int N = sc.nextInt();
		int sum = 0;
		
		int counter = 1;
		while(counter <= N)
		{
			sum = sum + N;
			counter = counter + 1;
		}
		System.out.println("sum = "+ sum);
	}

}
