import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows : ");
		int n = sc.nextInt();

		int row = 1;
		int nsp = n / 2;
		int nst = 1;
		while (row <= n) {
			// work for spaces
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			// work for stars
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}

			// prer for next row
			if (row <= n / 2) {
				nsp--;
				nst += 2;
			} else {
				nsp++;
				nst -= 2;
			}

			row++;
			System.out.println();
		}
	}
}
