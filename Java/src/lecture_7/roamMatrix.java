package lecture_7;

public class roamMatrix {

	public static void main(String[] args) {
		int[][] one = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 } };
		posRoamMatrix(one);
		// exitPoint(one);
	}

	private static void exitPoint(int[][] one) {
		int dir = 0; // 0-east, 1-south, 2-west, 3-north

		int row = 0, col = 0;
		while (true) {

			dir += one[row][col];
			dir %= 4;
			if (dir == 0) {
				col++;
				if (col == one[0].length) {
					System.out.println(row + " " + (one[0].length - 1));
					break;
				}
			} else if (dir == 1) {
				row++;
				if (row == one.length) {
					System.out.println((one.length - 1) + " " + col);
					break;
				}
			} else if (dir == 2) {
				col--;
				if (col == -1) {
					System.out.println(row + " " + 0);
					break;
				}
			} else {
				row--;
				if (row == -1) {
					System.out.println(0 + " " + col);
					break;
				}
			}
		}
	}

	private static void posRoamMatrix(int[][] a) {
		int rowmax = a.length, colmax = a[0].length, rowmin = 0, colmin = 0;
		int rowChange = 0, colChange = 1;
		int row = 0, col = 0;
		int rrChange = 1, ccChange = -1;

		while (true) {
			row += rowChange;
			col += colChange;

			if (row >= rowmin && row < rowmax && col >= colmin && col < colmax) {
				
				if (a[row][col] == 1) {
					rowChange += rrChange;
					colChange += ccChange;

					if (rowChange == 1 || rowChange == -1) {
						rrChange *= -1;
					}
					if (colChange == 1 || colChange == -1) {
						ccChange *= -1;
					}
				}
			}
			else {
				break;
			}
		}
		System.out.println((row-rowChange)+ " " + (col-colChange));
	}
}
