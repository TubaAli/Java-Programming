package Lecture_3;

import java.util.Scanner;

public class ab2d {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the source base : ");
		int srcb = sc.nextInt();
		System.out.println("Enter the number in that base : ");
		int n = sc.nextInt();
		
		int db = 10;
		int srcbkipow=1;
		int dest = 0;
		while(n!=0){
			int r = n%db;
			int q = n/db;
			dest+=r*srcbkipow;
			srcbkipow*=srcb;
			n=q;
		}
		System.out.print(dest);
	}

}
