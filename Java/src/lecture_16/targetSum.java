package lecture_16;

import java.util.Scanner;

public class targetSum {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		//printEquiSubsets(arr, "", "", 0, 0, 0);
		printTargetSumSubset(arr,0,70,0,"");
	}

	private static void printTargetSumSubset(int[] arr, int i, int target,int sum, String str) {
		if (i == arr.length) {
			if (sum == target) {
				System.out.println(str);
			}
			return;
		}
		printTargetSumSubset(arr,i+1,target,sum+arr[i],str+arr[i]);
		printTargetSumSubset(arr,i+1,target,sum,str+"");
	}

	private static void printEquiSubsets(int[] arr, String set1, String set2, int i, int sg1, int sg2) {
		if (i == arr.length) {
			if (sg1 == sg2) {
				System.out.println(set1 + " & " + set2);
			}
			return;
		}
		printEquiSubsets(arr, set1 + arr[i], set2, i + 1, sg1 + arr[i], sg2);
		printEquiSubsets(arr, set1, set2 + arr[i], i + 1, sg1, sg2 + arr[i]);
	}
}
