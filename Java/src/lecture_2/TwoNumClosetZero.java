package lecture_2;

import java.util.Arrays;

public class TwoNumClosetZero {

	public static void main(String[] args) {
		int arr[] = { 0, 60, -1, 0, 11, 30 };
		minSumPair(arr, 6);
	}

	private static void minSumPair(int[] arr, int size) {
		int min_l = 0, min_r = size - 1, sum = 0;
		int min_sum = 9999, l = 0, r = size - 1;
		Arrays.sort(arr);

		while (l < r) {
			sum = arr[l] + arr[r];
			if (Math.abs(sum) < Math.abs(min_sum)) {
				min_sum = sum;
				min_l = l;
				min_r = r;
			}
			if(sum<0){
				l++;
			}
			else{
				r--;
			}
		}
		System.out.print(arr[min_l] + " " + arr[min_r]);
	}
}
