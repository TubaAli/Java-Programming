package Lecture_6;

import java.util.Scanner;

public class mooreVotingAlgo {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeInput();
		majorityCheck(arr);
	}

	private static void majorityCheck(int[] arr) {
		int maj = arr[0], count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (maj == arr[i])
				count++;
			else {
				count--;
			}

			if (count == 0) {
				maj = arr[i];
				count = 1;
			}
		}
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == maj)
				count++;
		}
		if (count > arr.length / 2)
			System.out.println(maj);
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
