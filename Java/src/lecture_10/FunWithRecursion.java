package lecture_10;

import java.util.Scanner;

public class FunWithRecursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();
//		 printDecreasing(n);
//		 printIncreasingADecreasing(n);
//		 printIncreasing(n);
//		int fact = Factorial(n);
//		System.out.println(fact);
//		int num = Power(x,n);
//		int num = betterPower(x,n);
//		System.out.println(num);
//		int fib = fibbonacci(n);
//		System.out.println(fib);
//		toh("a","b","c",3);
	}

	private static void toh(String src, String dest, String helper, int i) {
		if(i==0){
			return;
		}
		toh(src,helper,dest,i-1);
		System.out.println("Move "+ i +" from "+src+" to "+dest);
		toh(helper,dest,src,i-1);
	}

	private static int fibbonacci(int n) {
		if(n==0){
			return 0;
		}
		if(n==1){
			return 1;
		}
		System.out.println("hey "+n);
		int fibnm1 = fibbonacci(n-1);
		System.out.println((n-1)+" from hey to bye "+(n-2));
		int fibnm2 = fibbonacci(n-2);
		System.out.println("bye "+n);
		int fibn = fibnm1+fibnm2;
		
		return fibn;
	}

	private static int betterPower(int x, int n) {
		if(n==0){
			return 1;
		}
	   int xkipownb2 = betterPower(x,n/2);
	   int xkipown = 1;
	   if(n%2==0){
		   xkipown = xkipownb2*xkipownb2;
	   } else{
		   xkipown = xkipownb2*xkipownb2*x;
	   }
	   return xkipown;
	}

	private static int Power(int x, int n) {
		if(n==0){
			return 1;
		}
		return x*Power(x,n-1);
	}

	private static int Factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * Factorial(n - 1);
	}

	private static void printDecreasing(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		printDecreasing(n - 1);
	}

	private static void printIncreasingADecreasing(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		printIncreasingADecreasing(n - 1);
		System.out.println(n);
	}

	public static void printIncreasing(int n) {
		if (n == 0) {
			return;
		}
		printIncreasing(n - 1);
		System.out.println(n);
	}
}
