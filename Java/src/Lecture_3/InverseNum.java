package Lecture_3;

import java.util.Scanner;

public class InverseNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = sc.nextInt();
		
		int num=0;
		int i = 1;
		while(n!=0){
			int r = n%10;
			int q = n/10;
		    num+= i*(int)Math.pow(10, r-1);
		    i++;
			n=q;
		}
		System.out.print(num);
	}
}
