package Lecture_4;

import java.util.Scanner;

public class charTest {

	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		char n = sc.next().charAt(0);
		printCase(n);
	}
	public static void printCase(char ch){
		if(ch>='a' && ch<='z')
			System.out.println("lowercase");
		else if(ch>='A' && ch<='Z')
			System.out.println("upper case");
		else System.out.println("special char");
	}

}
