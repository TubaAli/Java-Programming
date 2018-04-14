package lecture_5;

import java.util.Scanner;

public class stuffWithArray {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeInput();
		// display(arr);
		// int maxi = max(arr);
		// System.out.println(maxi);
		// System.out.println("Enter the element to be searched: ");
		// int n = sc.nextInt();
		// int pos = linearSearch(arr, n);
		// System.out.println(pos);

		display(arr);
		// reverse(arr);
		// int a[] = inverse(arr);
		// display(a);

		boolean b = mirrorInverse(arr);
		System.out.print(b);
	}

	private static int[] inverse(int[] arr) {
		int[] inv = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			inv[arr[i]] = i;
		}
		return inv;
	}

	public static boolean mirrorInverse(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			if (arr[arr[i]] != i)
				return false;
		return true;
	}

	public static void reverse(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < (arr.length) / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[n - 1];
			arr[n - 1] = temp;
			n--;
		}
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static int linearSearch(int[] arr, int n) {
		int pos = -1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n) {
				return i + 1;
			}
		}
		return pos;
	}

	public static int max(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	public static int[] takeInput() {
		int[] retVal = null;
		System.out.print("Enter the size of array : ");
		int n = sc.nextInt();
		retVal = new int[n];

		System.out.print("Enter the elements of array : ");
		for (int i = 0; i < retVal.length; i++) {
			retVal[i] = sc.nextInt();
		}
		return retVal;
	}
}
