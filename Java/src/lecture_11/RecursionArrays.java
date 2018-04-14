package lecture_11;

public class RecursionArrays {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 2, 3, 4, 1, 2, 3, 4, 2, 3, 5 };
		// display(arr,0);
		// displayReverse(arr,0);
		// int max = display_max(arr,0);
		// System.out.println(max);

		// boolean pos = find(arr,0,2);
		// System.out.println(pos);

		// int pos = firstIndex(arr,0,44);
		// System.out.println(pos);

//		int pos = lastIndex(arr, 0, 22);
//		System.out.println(pos);

		 int[] b = allIndices(arr,0,2,0);
		 for(int i = 0; i<b.length; i++){
		 System.out.print(b[i]+" ");
		 }
	}

	private static int[] allIndices(int[] arr, int i, int data, int fsf) {
		if(i == arr.length){
			return new int[fsf];
		}
		
		if(arr[i] == data){
			int[] indices = allIndices(arr, i + 1, data, fsf + 1);
			indices[fsf] = i;
			return indices;
		} else {
			int[] indices = allIndices(arr, i + 1, data, fsf);
			return indices;
		}
	} 

	private static int lastIndex(int[] arr, int i, int data) {
		if (i == arr.length) {
			return -1;
		}
		int pos = lastIndex(arr, i + 1, data);
		if (pos != -1) {
			return pos;
		} 
		else{
			if (arr[i] == data) {
				return i;
			} else {
				return -1;
			}
		}
	}

	private static int firstIndex(int[] arr, int i, int data) {
		if (i == arr.length) {
			return -1;
		}
		if (arr[i] == data) {
			return i;
		}
		int pos = firstIndex(arr, i + 1, data);
		return pos;
	}

	private static boolean find(int[] arr, int i, int data) {
		if (i == arr.length) {
			return false;
		}
		if (arr[i] == data) {
			return true;
		}
		boolean pos = find(arr, i + 1, data);
		return pos;
	}

	private static int display_max(int[] arr, int i) {
		if (i == arr.length) {
			return arr[i - 1];
		}
		int max = display_max(arr, i + 1);
		if (arr[i] > max) {
			max = arr[i];
		}
		return max;
	}

	private static void display(int[] arr, int i) {
		if (i == arr.length) {
			return;
		}
		System.out.print(arr[i] + " ");
		display(arr, i + 1);
	}

	private static void displayReverse(int[] arr, int i) {
		if (i == arr.length) {
			return;
		}
		displayReverse(arr, i + 1);
		System.out.print(arr[i] + " ");
	}
}
