import java.util.Scanner;

public class Pattern1_5_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n : ");
		int n = sc.nextInt();

		int row = 1;
		int num1 = 0;
		int num2 = 1;
		int num3 = 0;
		int fakenum2 = 1;
		int fakenum1 = 0;
		while (row <= n) {
			int col = 1;
			while (col <= row) {
				if (fakenum1 == 0) {
					System.out.print(num1);
					fakenum1++;
					
				} 
				else if (fakenum2 == 1) {
					System.out.print(num2 + " ");
					fakenum2++;
					
				}
				else{
				num3 = num1 + num2;
				num1 = num2;
				num2 = num3;
				System.out.print(num3 + " ");
				}
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
