package Lecture_3;

import java.util.Scanner;

public class conversions {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int srcb = sc.nextInt();
		int db = sc.nextInt();
		int n = sc.nextInt();

		int dest = ab2ab(srcb, db, n);
		System.out.print(dest);
	}

	public static int ab2d(int srcb, int n) {
		int dest = 0;
		int pow = 1;
		int db = 10;
		while (n != 0) {
			int r = n % db;
			int q = n / db;
			dest += r * pow;
			pow *= srcb;
			n = q;
		}
		return dest;
	}

	public static int d2ab(int n, int db) {
		int dest = 0;
		int pow = 1;
		int srcb = 10;
		while (n != 0) {
			int r = n % db;
			int q = n / db;
			dest += r * pow;
			pow *= srcb;
			n = q;
		}
		return dest;
	}

	public static int ab2ab(int srcb, int db, int n) {
		int dec = ab2d(srcb, n);
		int dest = d2ab(dec, db);
		return dest;
	}
}
