package lecture_19;

import java.util.Arrays;

public class mazePathDp {

	public static void main(String[] args) {
		// int n1 = printMazePathItr(2,2);
		// System.out.println(n1);
		// int n2 = printMazePathSlider(2, 2);
		// System.out.println(n2);
		int[][] strg = new int[3][3];
		strg[2][2] = 1;
		// int n3 = printMazePathRI(0, 0, 2, 2, strg);
		// System.out.println(n3);
		// int s1 = printMPWDItr(2, 2);
		// System.out.println(s1);
		// int s2 = printMPWDSlider(2, 2);
		// System.out.println(s2);
		// int s3 = printMPWDRI(2,2,0,0,strg);
		// System.out.println(s3);
		int[][] arr = { { 2, 1, 3, 4 }, { 2, 4, 2, 0 }, { 0, 1, 2, 6 }, { 5, 40, 3, 2 } };
		// int d1 = MinCostPathItr(arr, 3, 3);
		// System.out.println(d1);
		int d2 = MinCostPath(arr, 3, 3);
		System.out.println(d2);
	}

	private static int MinCostPath(int[][] arr, int dr, int dc) {
		int[][] strg = new int[dr + 1][dc + 1];

		String[][] path = new String[dr+1][dc+1];
		for (int row = arr.length - 1; row >= 0; row--) {
			for (int col = arr[0].length - 1; col >= 0; col--) {
				if (row + 1 <= arr.length - 1 && col + 1 <= arr.length - 1) {
					if(strg[row + 1][col + 1]<=strg[row + 1][col] && 
							strg[row + 1][col + 1]<=strg[row][col+1]){
						strg[row][col] = strg[row + 1][col + 1]+arr[row][col];
						path[row][col] = "d" +path[row + 1][col + 1];
					}
					else if(strg[row + 1][col]<=strg[row + 1][col+1] && 
							strg[row + 1][col]<=strg[row][col+1]){
						strg[row][col] = strg[row + 1][col]+arr[row][col];
						path[row][col] = "v"+path[row + 1][col];
					}
					else if(strg[row][col + 1]<=strg[row + 1][col+1] && 
							strg[row][col + 1]<=strg[row + 1][col]){
						strg[row][col] = strg[row][col + 1]+arr[row][col];
						path[row][col] = "h"+path[row][col + 1];
					}
				} 
				else if (row + 1 <= arr.length - 1) {
					strg[row][col] = strg[row + 1][col] + arr[row][col];
					path[row][col] = "v"+path[row + 1][col];
				} 
				else if (col + 1 <= arr[0].length - 1) {
					strg[row][col] = strg[row][col + 1] + arr[row][col];
					path[row][col] = "h"+path[row][col + 1];
				}
				else{
					strg[dr][dc] = arr[dr][dc];
					path[row][col] = "";
				}
			}
		}
		System.out.println(path[0][0]);
		return strg[0][0];
	}

	private static int MinCostPathItr(int[][] arr, int dc, int dr) {
		int[][] strg = new int[dr + 1][dc + 1];

		strg[dr][dc] = arr[dr][dc];

		for (int row = arr.length - 1; row >= 0; row--) {
			for (int col = arr[0].length - 1; col >= 0; col--) {
				int mincost = 999;
				if (row + 1 <= arr.length - 1 && col + 1 <= arr.length - 1) {
					int tot1 = strg[row + 1][col] + arr[row][col];
					int tot2 = strg[row][col + 1] + arr[row][col];
					int tot3 = strg[row + 1][col + 1] + arr[row][col];
					mincost = Math.min(Math.min(tot1, tot2), tot3);
					strg[row][col] = mincost;
				} else if (row + 1 <= arr.length - 1) {
					mincost = strg[row + 1][col] + arr[row][col];
					strg[row][col] = mincost;
				} else if (col + 1 <= arr.length - 1) {
					mincost = strg[row][col + 1] + arr[row][col];
					strg[row][col] = mincost;
				}
			}
		}
		return strg[0][0];
	}

	private static int printMPWDRI(int row, int col, int rowmax, int colmax, int[][] strg) {
		if (row == 0 && col == 0) {
			return strg[0][0];
		}
		if (row > rowmax || col > colmax || row < 0 || col < 0) {
			return strg[0][0];
		}
		int nv1 = printMPWDRI(row, col + 1, rowmax, colmax, strg);
		int nv2 = printMPWDRI(row + 1, col, rowmax, colmax, strg);
		strg[row][col] = nv1 + nv2;
		return strg[row][col];
	}

	private static int printMPWDSlider(int dc, int dr) {
		int[] strg = new int[dc + 1];
		for (int i = 0; i <= dc; i++) {
			strg[i] = 1;
		}
		Arrays.fill(strg, 1);
		for (int slide = 1; slide <= dr; slide++) {
			strg[dc] = 1;
			int temp = 1;
			for (int col = dc - 1; col >= 0; col--) {
				int nv = strg[col] + strg[col + 1] + temp;
				temp = strg[col];
				strg[col] = nv;
			}
		}
		return strg[0];
	}

	private static int printMPWDItr(int dc, int dr) {
		int[][] strg = new int[dr + 1][dc + 1];

		strg[dr][dc] = 1;

		for (int row = dr; row >= 0; row--) {
			for (int col = dc; col >= 0; col--) {
				if (row + 1 <= dr && col + 1 <= dc) {
					int tot = strg[row + 1][col] + strg[row][col + 1] + strg[row + 1][col + 1];
					strg[row][col] = tot;
				} else if (row + 1 <= dr) {
					int tot = strg[row + 1][col];
					strg[row][col] = tot;
				} else if (col + 1 <= dc) {
					int tot = strg[row][col + 1];
					strg[row][col] = tot;
				}
			}
		}
		return strg[0][0];
	}

	// nhi huaaaa
	private static int printMazePathRI(int row, int col, int rowmax, int colmax, int[][] strg) {
		if (row == rowmax && col == colmax) {
			return strg[row][col];
		}
		if (row > rowmax) {
			return strg[rowmax - 1][col];
		}
		if (col > colmax) {
			return strg[row][colmax - 1];
		}
		if (strg[row][col] != 0) {
			return strg[row][col];
		}
		int n = printMazePathRI(row, col + 1, rowmax, colmax, strg);
		int m = printMazePathRI(row + 1, col, rowmax, colmax, strg);
		int val = n + m;
		strg[row][col] = val;
		return strg[row][col];
	}

	private static int printMazePathSlider(int dr, int dc) {
		int[] strg = new int[dr + 1];
		for (int i = 0; i < dr; i++) {
			strg[i] = 1;
		}
		for (int slide = 1; slide <= dr; slide++) {
			strg[dr] = 1;
			for (int col = dc - 1; col >= 0; col--) {
				strg[col] = strg[col] + strg[col + 1];
			}
		}
		return strg[0];
	}

	private static int printMazePathItr(int dr, int dc) {
		int[][] strg = new int[dr + 1][dc + 1];

		strg[dr][dc] = 1;
		for (int row = dr; row >= 0; row--) {
			for (int col = dc; col >= 0; col--) {
				if (row + 1 <= dr && col + 1 <= dc) {
					int tot = strg[row + 1][col] + strg[row][col + 1];
					strg[row][col] = tot;
				} else if (row + 1 <= dr) {
					int tot = strg[row + 1][col];
					strg[row][col] = tot;
				} else if (col + 1 <= dc) {
					int tot = strg[row][col + 1];
					strg[row][col] = tot;
				}
			}
		}
		return strg[0][0];
	}

}
