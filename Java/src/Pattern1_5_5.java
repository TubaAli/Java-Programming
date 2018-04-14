import java.util.Scanner;

public class Pattern1_5_5 {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Enter n : ");
		int n = sc.nextInt();
		
		int counter = 0;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<=i; j++)
				System.out.print(++counter+" ");
			System.out.println();
		}
	}
}
