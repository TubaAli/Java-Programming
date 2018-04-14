package lecture_12;

public class HighLevelRecursion {

	public static void main(String[] args) {
		int[] a = { 55,100,33,22,88 };
		// bubbleSort(a, 0, a.length - 1);
		//selectionSort(a, 0, 1);
		InsertionSort(a,0,1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void bubbleSort(int[] a, int si, int ei) {
		if (ei == 0) {
			return;
		}
		if (si >= ei) {
			bubbleSort(a, 0, ei - 1);
			return;
		}
		if (a[si] > a[si + 1]) {
			int temp = a[si];
			a[si] = a[si + 1];
			a[si + 1] = temp;
		}
		bubbleSort(a, si + 1, ei);
	}

	private static void selectionSort(int[] a, int si, int ei) {
		if (si == a.length) {
			return;
		}
		if (ei == a.length) {
			selectionSort(a, si + 1, si + 2);
			return;
		}
		if (a[si] > a[ei]) {
			int temp = a[si];
			a[si] = a[ei];
			a[ei] = temp;
		}
		selectionSort(a, si, ei + 1);
	}
	
	private static void InsertionSort(int[] a, int si, int ei) {
		if (ei == a.length) {
			return;
		}
		
		if (si == ei) {
			InsertionSort(a,0,ei+1);
			return;
		}
		
		if (a[si] > a[ei]) {
			int temp = a[si];
			a[si] = a[ei];
			a[ei] = temp;
		}
		InsertionSort(a,si+1,ei);
	}
}
