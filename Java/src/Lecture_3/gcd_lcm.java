package Lecture_3;

import java.util.Scanner;

public class gcd_lcm {

	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Enter n1 : ");
		int n1 = sc.nextInt();
		System.out.print("Enter n2 : ");
		int n2 = sc.nextInt();
		
		int gcd = calc_gcd(n1,n2);
		int lcm = calc_lcm(n1,n2,gcd);
		System.out.println("hcf = "+gcd);
		System.out.println("lcm = "+lcm);
	}
	public static int calc_gcd(int n1, int n2){
		int r = 1;
		while(r!=0){
			r = n1%n2;
			n1 = n2;
			n2 = r;
		}
		return n1;
	}
	public static int calc_lcm(int n1, int n2, int gcd){
		int lcm = (n1*n2)/gcd;
		return lcm;
	}
}
