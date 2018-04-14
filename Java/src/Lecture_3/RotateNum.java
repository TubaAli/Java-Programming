package Lecture_3;

import java.util.Scanner;

public class RotateNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number to be rotated : ");
		int n = sc.nextInt();
		System.out.print("Enter the place to be rotated : ");
		int r = sc.nextInt();
		
		int num = rotateDigit(n,r);
		System.out.println(num);
	}
	
	public static int rotateDigit(int n, int r){
		int d = countDigit(n);
		int num = 0; 
		
		int rem = (int) ((int) n%Math.pow(10, r));
		int q = (int) ((int) n/Math.pow(10, r));
		num+=rem*Math.pow(10, d-r)+q;
		return num;
	}
	
	public static int countDigit(int n){
		int counter = 0;
		while(n!=0){
			int r = n/10;
			counter++;
			n = r;
		}
		return counter;
	}
}
