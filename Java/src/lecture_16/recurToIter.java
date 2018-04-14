package lecture_16;

public class recurToIter {

	public static void main(String[] args) {
		int[] wts = { 20, 30, 50, 10, 5 };
		int[] costs = { 10, 20, 2, 15, 100 };
		int capacity = 50;
		// int maxCost = knapsack1(wts, costs, 0, capacity, 0);
		knapsack2(wts, costs, 0, capacity, 0);
		System.out.println(max);
		// System.out.println(maxCost);
	}

	static int max = 0;

	private static void knapsack2(int[] wts, int[] costs, int i, int capacity, int csf) {
		if (i == wts.length) {
			if (csf > max) {
				max = csf;
			}
			return;
		}
		knapsack2(wts, costs, i + 1, capacity, csf);
		if (wts[i] <= capacity) {
			knapsack2(wts, costs, i + 1, capacity - wts[i], csf + costs[i]);
		}
	}

	private static int knapsack1(int[] wts, int[] costs, int i, int capacity, int csf) {
		if (i == wts.length || capacity == 0) {
			return csf;
		}
		if (capacity >= wts[i]) {
			int c1 = knapsack1(wts, costs, i + 1, capacity - wts[i], csf + costs[i]);
			int c2 = knapsack1(wts, costs, i + 1, capacity, csf);
			if (c1 > c2) {
				csf = c1;
			} else {
				csf = c2;
			}
		} else {
			csf = knapsack1(wts, costs, i + 1, capacity, csf);
		}
		return csf;
	}
}
