package Lecture_3;

import java.util.Scanner;

public class mirrorNum {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		int originalN = n;
		int num = 0;
		int i = 1;
		while(n!=0){
			int r = n%10;
			int q = n/10;
			num += (int)(i*Math.pow(10, r-1));
			i++;
			n = q;
		}
		if(num==originalN)
			System.out.println("The number is mirrored of itself");
		else System.out.println("The number is not mirrored");
	}

}
