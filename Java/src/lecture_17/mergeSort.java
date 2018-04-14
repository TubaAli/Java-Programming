package lecture_17;

public class mergeSort {

	public static void main(String[] args) {
		int[] a1 = {1,8,7,88,22,5,9,8,9};
		int[] arr = merging(a1,0,a1.length-1);
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}

	private static int[] merging(int[] arr,int lo, int hi){
		if(lo==hi){
			int[] ba = new int[1];
			ba[0] = arr[lo];
			return ba;
		}
		int mid = (lo+hi)/2;
		int[] one = merging(arr,lo, mid);
		int[] two = merging(arr,mid+1, hi);
		int[] sorted = mergeTwoSortedArray(one,two);
		return sorted;
	}
	private static int[] mergeTwoSortedArray(int[] one, int[] two) {
		int[] arr = new int[one.length+two.length];
		int i=0, j=0, k=0;
		while(i<one.length && j<two.length){
			if(one[i]<=two[j]){
				arr[k] = one[i];
				i++;
				k++;
			}
			else{
				arr[k] = two[j];
				k++;
				j++;
			}
		}
		while(i<one.length){
			arr[k] = one[i];
			k++;
			i++;
		}
		while(j<two.length){
			arr[k] = two[j];
			k++;
			j++;
		}
		return arr;
	}
}
