import java.util.Scanner;

public class Fib {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num1 = 0;
		int num2 = 1;
		if(n==1){
			System.out.print("0");
		}
		else if(n==2){
			System.out.print("1");
		}
		else{
			int i = 3, num3 = 0;
			while (i <= n) {
				num3 = num1 + num2;
				num1 = num2;
				num2 = num3;
				i++;
			}
			System.out.println(num3);
		}
	}
}
