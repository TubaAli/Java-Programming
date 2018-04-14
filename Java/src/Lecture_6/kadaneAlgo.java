package Lecture_6;

import java.util.Scanner;

public class kadaneAlgo {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = takeInput();
		largestSumArray(arr);
	}

	private static void largestSumArray(int[] arr) {
		int current_max = arr[0], cstart = 0, cend = 0;
		int max = arr[0], mstart = 0, mend = 0;
		for (int i = 1; i < arr.length; i++) {
			if (current_max + arr[i] < arr[i]) {
				current_max = arr[i];
				cstart = i;
				cend = i;
			} else {
				current_max += arr[i];
				cend = i;
			}
			if (current_max > max) {
				max = current_max;
				mstart = cstart;
				mend = cend;
			}
		}
		System.out.println(max);
		System.out.println(mstart + " " + mend);
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
