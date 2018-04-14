import java.util.Scanner;

public class Pattern1_5_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n : ");
		int n = sc.nextInt();
		
		int row = 1;
		int nsp = 1;
		int nst = (n+1)/2;
		while(row<=n)
		{
			int cst=1;
			while(cst<=nst)
			{
				System.out.print("*");
				cst++;
			}
			int csp=1;
			while(csp<=nsp)
			{
				System.out.print(" ");
				csp++;
			}
			int cst2=1;
			while(cst2<=nst)
			{
				System.out.print("*");
				cst2++;
			}
			if(row<=n/2)
			{
				nsp+=2;
				nst-=1;
			}else{
				nsp-=2;
				nst+=1;
			}
			System.out.println();
			row++;
		}
	}
}
