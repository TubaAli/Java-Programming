package lecture_20;

public class mcm {

	public static void main(String[] args) {
		// int[] dims = {10,20,30,40,50,60};
		// int cost = MCMul(dims,0,dims.length-1, new
		// int[dims.length][dims.length]);
		// System.out.println(cost);
		String str = "abbaa";
		int minc = PalindPart(str, 0, str.length() - 1, new int[str.length()][str.length()]);
		System.out.println(minc);
	}

	private static int PalindPart(String str, int si, int en, int[][] strg) {
		if (isPalindrome(str.substring(si, en + 1))) {
			return 0;
		}
		if (si + 1 == en) {
			return 1;
		}
		if(strg[si][en]!=0){
			return strg[si][en];
		}
		int mincost = Integer.MAX_VALUE;
		for (int i = si ; i < en; i++) {
			int cost1 = PalindPart(str, si, i,strg);
			int cost2 = PalindPart(str, i + 1, en,strg);
			int totalcost = cost1 + cost2 + 1;
			if (totalcost < mincost) {
				mincost = totalcost;
			}
		}
		strg[si][en] = mincost;
		return mincost;
	}

	private static boolean isPalindrome(String str) {
		for (int left = 0, right = str.length() - 1; left < right; left++, right--) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
		}
		return true;
	}

	private static int MCMul(int[] dims, int si, int en, int[][] strg) {
		if ((si + 1) == en) {
			return 0;
		}
		if (strg[si][en] != 0) {
			return strg[si][en];
		}

		int mincost = Integer.MAX_VALUE;
		for (int i = si + 1; i < en; i++) {
			int cost1 = MCMul(dims, si, i, strg);
			int cost2 = MCMul(dims, i, en, strg);
			int cost3 = dims[si] * dims[i] * dims[en];
			int totalcost = cost1 + cost2 + cost3;

			if (totalcost < mincost) {
				mincost = totalcost;
			}
		}
		strg[si][en] = mincost;
		return mincost;
	}
}
