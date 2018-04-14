package lecture_5;

import java.util.Scanner;

public class rotateArray {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int[] arr = takeInput();
		display(arr);
		System.out.println("Enter the rotation point : ");
		int r = sc.nextInt();
		rotateArray1(arr,r);
		display(arr);
		
	}
	private static void rotateArray1(int[] arr, int r) {
		int i = 0, j = 0;
		int[] arr2 = new int[r];
		for(int l = 0; l < r; l++){
			arr2[l] = arr[j];
			j++;
		}
		j = 0;
		for(i = r; i<arr.length; i++){
			arr[j] = arr[i];
			j++;
		}
		j = 0;
		for(int k = arr.length-r; k<arr.length; k++){
			arr[k] = arr2[j];
			j++;
		}
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

	public static void display(int[] arr) {
		for(int i = 0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
