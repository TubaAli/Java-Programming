package Lecture_4;

import java.util.Scanner;

public class setBitsFromN1toN2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n1 : ");
		int n1 = sc.nextInt();
		System.out.print("Enter n2 : ");
		int n2 = sc.nextInt();
		
		int count = 0;
		for(int i=n1; i<=n2; i++){
	        int c = countSetBit(i);
	        count += c; 
	    }
		System.out.println(count);
	}
	public static int countSetBit(int n){
		int count=0;
		while(n!=0){
			count+=n&1;
			n>>=1;
		}
		return count;
	}
}
