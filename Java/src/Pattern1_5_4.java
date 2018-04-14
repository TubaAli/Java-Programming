import java.util.Scanner;

public class Pattern1_5_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n : ");
		int n = sc.nextInt();

		int row = 1;
		while (row <= n) {
			int col = 1;
			while (col <= n) {
				if (row == col)
					System.out.print("*");
				else if (row + col == n + 1)
					System.out.print("*");
				else
					System.out.print(" ");
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
