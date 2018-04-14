import java.util.Scanner;

public class Pattern1_5_7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = sc.nextInt();
		
		int row = 0;
		
		while(row<n)
		{
			int col = 0;
			int val = 1;
			while(col<=row)
			{
				System.out.print(val);
				int ncval = val*(row-col)/(col+1);
				val = ncval;
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
