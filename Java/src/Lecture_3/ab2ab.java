package Lecture_3;

import java.util.Scanner;

public class ab2ab {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Enter the source base : ");
		int srcb = sc.nextInt();
		System.out.print("Enter the destination base : ");
		int db = sc.nextInt();
		System.out.print("Enter the number to be converted : ");
		int n = sc.nextInt();
		
		int pow1 = 1;
		int pow2=1;
		int decb = 10;
		int decn = 0;
		while(n!=0){
			int r = n%decb;
			int q = n/decb;
			decn+=r*pow1;
			pow1*=srcb;
			n=q;
		}
		int dest = 0;
		while(decn!=0){
			int r = decn%db;
			int q = decn/db;
			dest+=r*pow2;
			pow2*=decb;
			decn=q;
		}
		System.out.print(dest);
	}

}
