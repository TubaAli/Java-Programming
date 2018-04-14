package lecture_20;

public class lcs {

	public static void main(String[] args) {
		String str1 = "abghef";
		String str2 = "abefgh";
//		int m = str1.length();
//		int n = str2.length();
//		int[][] mat = new int[m + 1][n + 1];
//		int cost = lcsCount(mat, str1, str2, m, n,"");
//		System.out.print(" "+cost);
//		
		int len = lcsLen(str1,str2);
		System.out.println(len);
	}
	
	private static int lcsLen(String str1, String str2) {
		int[][] board = new int[str1.length()+1][str2.length()+1];
		
		for(int i=1; i<board.length; i++){
			for(int j=1; j<board[0].length; j++){
				if(str1.charAt(i-1)==str2.charAt(i-1)){
					board[i][j] +=board[i-1][j-1]+1;
				}
				else{
					board[i][j] = Math.max(board[i-1][j], board[i][j-1]);
				}
			}
		}
		return board[board.length-1][board[0].length-1];
	}

	private static int lcsCount(int[][] mat, String str1, String str2, int m, int n, String ans) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (mat[m][n] != 0) {
			return mat[m][n];
		}
		if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
			int ans1 = 1 + lcsCount(mat, str1, str2, m - 1, n - 1,ans);
			mat[m][n] = ans1;
			ans += str1.charAt(m-1)+"";
			System.out.print(ans);
			return ans1;
		} else {
			int ans2 = Math.max(lcsCount(mat, str1, str2, m - 1, n,ans), lcsCount(mat, str1, str2, m, n - 1,ans));
			mat[m][n] = ans2;
			return ans2;
		}
	}
}
