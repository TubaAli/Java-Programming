package lecture_18;

public class quicksort {

	public static void main(String[] args) {
		int[] arr = {20,10};
		quickSort(arr,0,arr.length-1);
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i]+" ");
		}
	}

	private static void quickSort(int[] arr, int lo, int hi) {
		if(lo>=hi){
			return;
		}
		int pivot = arr[(lo+hi)/2];
		int left = lo;
		int right = hi;
		while(left<=right){
			while(arr[left]<pivot){
				left++;
			}
			while(arr[right]>pivot){
				right--;
			}
			if(left<=right){
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		quickSort(arr,lo,right);
		quickSort(arr,left,hi);
	}
}
