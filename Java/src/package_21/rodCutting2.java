package package_21;

public class rodCutting2 {

	public static void main(String[] args) {
		// int[] rod = { 0, 2, 6, 7, 10, 8, 9, 12, 11 };
		// rodcutting(rod, 8);
		// System.out.println(palindromicStr("abccbc",0,5,new int[6][6]));
		int[] wts = { 2, 3, 1, 4, 2 };
		int[] costs = { 100, 50, 17, 22, 80 };
		knapsack(wts, costs, 7, 5);
	}

	private static void knapsack(int[] wts, int[] costs, int cap, int noi) {
		int[][] strg = new int[cap + 1][noi + 1];
		for (int i = 1; i < strg.length; i++) {
			for (int j = 1; j < strg[0].length; j++) {
				if (i - wts[j - 1] >= 0) {
					strg[i][j] = Math.max(strg[i][j - 1], strg[i - wts[j - 1]][j - 1] + costs[j - 1]);
				}else{
					strg[i][j] = strg[i][j-1];
				}
			}
		}
		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				System.out.print(strg[i][j]+" ");
			}
			System.out.println();
		}
	}

	private static int palindromicStr(String str, int si, int en, int[][] qb) {
		if (isPal(str, si, en) == true) {
			return 0;
		}
		if (qb[si][en] != 0) {
			return qb[si][en];
		}
		int min = 5;
		for (int i = si; i < en; i++) {
			int tcl = palindromicStr(str, si, i, qb);
			int tcr = palindromicStr(str, i + 1, en, qb);
			int tc = tcl + tcr + 1;
			if (tc < min) {
				min = tc;
			}
		}
		qb[si][en] = min;
		return min;
	}

	private static boolean isPal(String str, int si, int en) {
		for (int left = si, right = en; left < right; left++, right--) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
		}
		return true;
	}

	private static void rodcutting(int[] rod, int length) {
		int[] strg = new int[rod.length];
		String[] str = new String[rod.length];
		strg[0] = 0;
		strg[1] = rod[1];
		str[0] = "0";
		str[1] = 1 + "";
		for (int i = 2; i < rod.length; i++) {
			int cost = rod[i];
			String newstr = i + "";
			for (int left = 1, right = i - 1; left <= right; left++, right--) {
				int newcost = strg[left] + strg[right];
				if (newcost > cost) {
					cost = newcost;
					newstr = str[left] + str[right] + "";
				}
			}
			strg[i] = cost;
			str[i] = newstr + "";
		}
		for (int i = 0; i < strg.length; i++) {
			System.out.print(strg[i] + " ");
		}
		System.out.println(".");
		System.out.println(str[str.length - 1]);
	}
}
