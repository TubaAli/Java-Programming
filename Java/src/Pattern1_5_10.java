import java.util.Scanner;

public class Pattern1_5_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n : ");
		int n = sc.nextInt();

		int row = 1;
		int nsp = 2 * n;
		int nst = 1;
		while (row <= n) {
			int col = 1;
			int val = 1;
			while (col <= row) {
				System.out.print(val);
				val += 1;
				col++;
			}
			int csp = 1;
			while (csp < nsp - 2) {
				System.out.print(" ");
				csp++;
			}
			int cst = 1;
			while (cst <= nst) {
				if (val == n + 1)
					val -= 2;
				else
					val -= 1;
				System.out.print(val);
				if (cst < n - 1)
					cst++;
				else {
					break;
				}
			}
			if (nsp == 1)
				break;
			else {
				nsp -= 2;
				nst += 1;
			}
			System.out.println();
			row++;
		}
	}
}
