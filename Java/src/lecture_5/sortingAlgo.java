package lecture_5;

import java.util.Scanner;

public class sortingAlgo {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int[] arr = takeInput();
		display(arr);
		//bubbleSort(arr);
		//selectionSort(arr);
		insertionSort(arr);
		display(arr);
	}

	private static void insertionSort(int[] arr) {
		int counter = 1;
		while(counter<=arr.length-1){
			//activity for each selection
			for(int i=counter; i>0; i--){
				if(arr[i-1]>arr[i]){
					int temp  = arr[i-1];
					arr[i-1] = arr[i];
					arr[i] = temp;
				}
				else{
					break;
				}
			}
			counter++;
		}
	}

	private static void selectionSort(int[] arr) {
		int counter = 1;
		while(counter<=arr.length-1){
			//activity for one selection
			for(int i = counter; i<arr.length; i++){ //compared with
				if(arr[counter-1]>arr[i]){ //comparison wala
					int temp = arr[i];
					arr[i] = arr[counter-1];
					arr[counter-1] = temp;
				}
			}
			counter++;
		}
	}

	private static void bubbleSort(int[] arr) {
		int counter = 1;
		while(counter<=arr.length-1){
			//activity of each bubbling
			for(int i = 0; i < arr.length-counter; i++){
				if(arr[i+1]<arr[i]){
					int temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
				}
			}
			counter++;
		}
	}

	public static int[] takeInput() {
		int[] retVal = null;
		System.out.print("Enter the size of array : ");
		int n = sc.nextInt();
		retVal = new int[n];

		System.out.print("Enter the elements of array : ");
		for (int i = 0; i < retVal.length; i++) {
			retVal[i] = sc.nextInt();
		}
		return retVal;
	}

	public static void display(int[] arr) {
		for(int i = 0; i<arr.length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
