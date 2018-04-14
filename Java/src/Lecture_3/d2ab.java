package Lecture_3;

import java.util.Scanner;

public class d2ab {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n in decimal format: ");
		System.out.println("Enter the destination base");
		int n = sc.nextInt();
		int db = sc.nextInt();
		int dest = 0;
		int srcb = 10;
		int pow = 1;
		while(n!=0){
			int r = n%db;
			int q = n/db;
			dest+=r*pow;
			pow*=srcb;
			n = q;
		}
		System.out.print(dest);
	}

}
