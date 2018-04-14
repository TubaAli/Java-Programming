package lecture_5;

import java.util.Scanner;

public class sumOfTwoArray {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int[] arr1 = takeInput();
		int[] arr2 = takeInput();
		display(arr1);
		display(arr2);
		int[] sum = getSum(arr1, arr2);
		display(sum);
	}

	private static int[] getSum(int[] a1, int[] a2) {
		if(a1.length<a2.length){
			getSum(a2,a1);
		}
		int s1 = a1.length-1, s2 = a2.length-1;
		int[] a3 = new int[s1+1];
		int carry = 0, j = 0;
		for(int i=s2; i>=0; i--){
			int sum = 0;
			sum+=a1[s1]+a2[i]+carry;
			a3[j] = sum%10;
			carry = sum/10;
			j++;
			s1--;
		}
		for(int i=s1; i>=0; i--){
			int sum = 0;
			sum+=a1[i]+carry;
			a3[j] = sum%10;
			carry = sum/10;
			j++;
		}
		if(j!=a3.length){
			a3[j] = carry;
		}
		int n = a3.length;
		for(int i=0; i<a3.length/2; i++){
			int temp = a3[i];
			a3[i] = a3[n-1];
			a3[n-1] = temp;
			n--;
		}
		return a3;
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
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
