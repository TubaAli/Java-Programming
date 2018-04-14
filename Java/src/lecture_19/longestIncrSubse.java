package lecture_19;

import java.util.Arrays;

public class longestIncrSubse {

	public static void main(String[] args) {
		int[] a = { 10, 22, 9, 33, 21, 50, 41, 60, 80, 1 };
		int num = LIS(a);
		System.out.println(num);
	}

	private static int LIS(int[] arr) {
		int[] count = new int[arr.length];
		String[] str = new String[arr.length]; 
		Arrays.fill(count, 0);
		Arrays.fill(str, "");
		
		
		count[0] = 1;
		str[0] = arr[0]+"";
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if(count[j]+1>count[i]){
						count[i] = count[j]+1;
						str[i] = str[j]+" "+arr[i];
					}
				}
			}
			if(count[i]==0){
				count[i] = 1;
				str[i]= arr[i]+"";
			}
		}
		int maxi = 0,maxind=0;
		for (int r = 0; r < count.length; r++) {
			if (count[r] > maxi) {
				maxi = count[r];
				maxind=r;
			}
		}
		System.out.println(str[maxind]);
		return maxi;
	}
}
