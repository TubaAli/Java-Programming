import java.util.Scanner;

public class Pattern1_5_8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = sc.nextInt();
		
		int row = 1;
		int nsp = n-1;
		int nst = 1;
		int val = 1;
		while(row<=n)
		{
			val = row;
			int csp=1;
			while(csp<=nsp)
			{
				System.out.print(" ");
				csp++;
			}
			int cst = 1;
			while(cst<=nst)
			{
				System.out.print(val);
				val = cst<=nst/2? val+1 : val-1;
				cst++;
			}
			
			nsp--;
			nst+=2;
			
			System.out.println();
			row++;
		}
	}

}
