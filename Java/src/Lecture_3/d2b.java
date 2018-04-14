package Lecture_3;

import java.util.Scanner;

public class d2b {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter n in decimal format");
		int n = sc.nextInt();
		
		int dest = 0;
		
		int srcb = 10;
		int db = 2;
		int powe = 1;

		while(n!=0){
			int r = n%db;
			int q = n/db;

			dest+=r*powe;
			powe*=srcb;
			n = q;
		}
		System.out.print(dest);
	}

}
