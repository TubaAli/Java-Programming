package Lecture_3;

import java.util.Scanner;

public class armstrongs {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Enter the number ");
		int ln = sc.nextInt(); //till what num(ln) you want to print armstrong

		int sn = 100;
		printArmstrong(sn, ln);
	}

	public static void printArmstrong(int sn, int ln) {
		for (int i = sn; i < ln; i++) {
			boolean isArmstrongCheck = isArmstrong(i);
			if (isArmstrongCheck == true) {
				System.out.print(i+" ");
			}
		}
	}

	public static boolean isArmstrong(int n) {
		int num = 0;
		int checkN = n;
		while (n != 0) {
			int r = n % 10;
			int q = n / 10;

			num += r * r * r;
			n = q;
		}
		if (num == checkN)
			return true;
		else
			return false;
	}
}
