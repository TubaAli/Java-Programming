package lecture_20;

public class IsTargetSum {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5 };
		boolean p = isTargetPresent(arr, 7);
		System.out.println(p);
	}

	private static boolean isTargetPresent(int[] arr, int target) {
		boolean[][] board = new boolean[arr.length + 1][target + 1];
		board[0][0] = true;
		for (int i = 0; i < arr.length + 1; i++) {
			board[i][0] = true;
		}
		for (int i = 1; i < board.length ; i++) {
			for (int j = 1; j < board[0].length; j++) {
				if (board[i - 1][j] == true) {
					board[i][j] = true;
				} else if (j - arr[i - 1] >= 0 && board[i - 1][j - arr[i - 1]] == true) {
					board[i][j] = true;
				}
			}
		}
		return board[board.length - 1][board[0].length - 1];
	}
}
