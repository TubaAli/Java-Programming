package lecture_2;

import java.util.*;

public class maniArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[n];
		for (int a0 = 0; a0 < m; a0++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();
			manipulateArray(arr, a, b, k);
		}
		display(arr);
	}

	public static void manipulateArray(int[] arr, int a, int b, int k) {
		for (int i = a; i <= b; i++) {
			arr[i] += k;
		}
	}

	public static void display(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
