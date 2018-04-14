package lecture_20;

import java.util.Arrays;

public class bitonicSubs {

	public static void main(String[] args) {
		int[] arr = { 1, 11, 2, 10, 4, 5, 2, 1 };
		bitonicSeq(arr);
	}

	private static void bitonicSeq(int[] arr) {
		int[] countD = new int[arr.length];
		int[] countI = new int[arr.length];

		countI[0] = 1;
		countD[arr.length - 1] = 1;

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (countI[j] + 1 > countI[i]) {
						countI[i] = countI[j] + 1;
					}
				}
			}
			if (countI[i] == 0) {
				countI[i] = 1;
			}
		}

		for (int i = arr.length-2; i >=0; i--) {
			for (int j = arr.length-1; j > i; j--) {
				if (arr[i] > arr[j]) {
					if (countD[j] + 1 > countD[i]) {
						countD[i] = countD[j] + 1;
					}
				}
			}
			if (countD[i] == 0) {
				countD[i] = 1;
			}
		}
		int omax = 0;
		for(int i=0; i<countD.length; i++){
			if(countI[i]+countD[i]>omax){
				omax = countI[i]+countD[i]-1; //bcz one element is being added again
			}
		}
		System.out.println(omax);
	}
}
