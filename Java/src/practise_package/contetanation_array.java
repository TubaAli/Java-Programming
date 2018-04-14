package practise_package;

import java.util.Scanner;

public class contetanation_array {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			int[] newArr = newArraybyK(arr, k);
			long maxsum = maxSumArray(newArr);
			System.out.println(maxsum);
		}
	}

	public static int[] newArraybyK(int[] arr, int k) {
		int n = arr.length;
		int[] newArr = new int[n * k];
		int i = 0;
		for (int j = 0; j < newArr.length; j++) {
			if (i < arr.length) {
				newArr[j] = arr[i];
				i++;
			} else {
				i = 0;
				newArr[j] = arr[i];
				i++;
			}
		}
		return newArr;
	}

	public static long maxSumArray(int[] a) {
		long max_so_far = a[0];
		long curr_max = a[0];

		for (int i = 1; i < a.length; i++) {
			if (a[i] + curr_max > a[i]) {
				curr_max += a[i];
			} else {
				curr_max = a[i];
			}
			if (curr_max > max_so_far) {
				max_so_far = curr_max;
			}
		}
		return max_so_far;
	}
}
