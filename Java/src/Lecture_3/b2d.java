package Lecture_3;

import java.util.Scanner;

public class b2d {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter the n in binary format");
		int n = sc.nextInt();

		int dest = 0;
		int srcb = 2;
		int db = 10;
		int pow = 1;
		while (n != 0) {
			int r = n % db;
			int q = n / db;

			dest += r * pow;
			pow *= srcb;
			n = q;
		}
		System.out.print(dest);
	}
}
