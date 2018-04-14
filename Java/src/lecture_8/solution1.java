package lecture_8;

import java.util.Scanner;

public class solution1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int[] prod = prodArr(arr);
		for(int i=0; i<n; i++){
			System.out.print(prod[i]+" ");
		}
	}

	public static int[] prodArr(int[] arr) {
		int[] prod = new int[arr.length];
		int j=0;
		while(j<arr.length){
			int mul = 1;
			for(int i=0; i<prod.length; i++){
				if(i!=j){
					mul*=arr[i];
				}
			}
			prod[j] = mul;
			j++;
		}
		return prod;
	}

}
