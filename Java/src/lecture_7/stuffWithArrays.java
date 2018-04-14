package lecture_7;

import java.util.Scanner;

public class stuffWithArrays {

	public static void main(String[] args) {
		int[][] one = { { 11, 12, 13 }, { 21, 22, 23 }, { 31, 32, 33 }, { 41, 42, 43 } };
		// display(one);
		// int[][] two = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		// int[][] two = takeInput();
		// display(two);
		
		// int[][] ans = matrixMul(one, two);
		// if (ans == null)
		// System.out.println("Can't multiply");
		// else
		// display(ans);
		// waveDisplay(one);
		sprialDisplay(one);
	}

	private static void sprialDisplay(int[][] one) {
		int rowmax = one.length - 1, colmax = one[0].length - 1;
		int rowmin = 0, colmin = 0;
		int noOdDigits = (rowmax + 1) * (colmax + 1);
		int count = 1, col = colmin, row = rowmin;
		while (count <= noOdDigits) {

			for (row = rowmin; row <= rowmax && count <= noOdDigits; row++) {
				System.out.print(one[row][colmin] + " ");
				count++;
			}
			colmin++;

			for (col = colmin; col <= colmax && count <= noOdDigits; col++) {
				System.out.print(one[rowmax][col] + " ");
				count++;
			}
			rowmax--;

			for (row = rowmax; row >= rowmin && count <= noOdDigits; row--) {
				System.out.print(one[row][colmax] + " ");
				count++;
			}
			colmax--;

			for (col = colmax; col >= colmin && count <= noOdDigits; col--) {
				System.out.print(one[rowmin][col] + " ");
				count++;
			}
			rowmin++;
		}
	}

	private static void waveDisplay(int[][] one) {
		int rows = one.length, cols = one[0].length;
		int col = 0, row = 0;
		while (col < cols) {
			if (col % 2 == 0) {
				row = 0;
				while (row < rows) {
					System.out.print(one[row][col] + " ");
					row++;
				}
			} else {
				row = rows - 1;
				while (row >= 0) {
					System.out.print(one[row][col] + " ");
					row--;
				}
			}

			col++;
		}
	}

	private static int[][] matrixMul(int[][] one, int[][] two) {
		int rowOne = one.length, colOne = one[0].length, rowTwo = two.length, colTwo = two[0].length;
		if (colOne != rowTwo)
			return null;
		int[][] ans = new int[rowOne][colTwo];

		for (int row = 0; row < ans.length; row++) {
			for (int col = 0; col < ans[0].length; col++) {
				for (int i = 0; i < rowTwo; i++) {
					ans[row][col] += one[row][i] * two[i][col];
				}
			}
		}
		return ans;
	}

	private static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] takeInput() {
		int[][] retVal = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the no of rows : ");
		int rows = sc.nextInt();

		retVal = new int[rows][];
		for (int row = 0; row < retVal.length; row++) {
			System.out.print("Enter the no of col in " + row + "th row");
			int cols = sc.nextInt();

			retVal[row] = new int[cols];
			System.out.print("enter the elements : ");
			for (int col = 0; col < retVal[row].length; col++) {
				retVal[row][col] = sc.nextInt();
			}
		}
		return retVal;
	}

}
