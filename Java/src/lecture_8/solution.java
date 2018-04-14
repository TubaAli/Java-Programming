package lecture_8;

import java.util.*;

public class solution{

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<arr.length; i++){
        	arr[i] = sc.nextInt();
        }
        int[] ret = specialNum(arr);
        for(int i=0; i<ret.length; i++){
        	if(ret[i]==ret[i+1]){
        		System.out.print(ret[i]+" ");
        		i=i+1;
        	}
        	else if(ret[i]!=0){
        		System.out.print(ret[i]+" ");
        	}else{
        		System.out.print(ret[i]+" ");
        	}
        }
   }

	private static int[] specialNum(int[] arr) {
		int[] ret = new int[arr.length];
		int k=0;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				if(arr[i]!=arr[j]){
					if(arr[i]%arr[j]==0){
						ret[k]=arr[i];
						k++;
					}
				}
			}
		}
		return ret;
	}
}
