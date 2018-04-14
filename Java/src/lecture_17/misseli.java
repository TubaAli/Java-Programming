package lecture_17;

public class misseli {

	public static void main(String[] args) {
		int[] arr1 = {1,6,3,4,7,2,7,5};
		int[] arr2 = {1,1,3,3,5,5,7,7,8};
		System.out.print(returnSingle(arr2));
		//System.out.print(returnDuplicate(arr1));
	}

	private static int returnSingle(int[] arr) {
		int val = 0;
		for(int i=0; i<arr.length; i++){
			val^=arr[i];
		}
		return val;
	}

	private static int returnDuplicate(int[] arr) {
		int val=0;
		for(int i=0; i<arr.length; i++){
			val^=arr[i];
		}
		for(int i=1; i<arr.length; i++){
			val^=i;
		}
		return val;
	}

}
