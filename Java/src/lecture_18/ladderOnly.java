package lecture_18;

import java.util.Arrays;

public class ladderOnly {

	public static void main(String[] args) {
		int[] board = printPrimeSOE(20);
		possiblePaths(0, 20, board, "");
	}

	private static void possiblePaths(int curr, int end, int[] board, String ssf) {
		if (curr > end) {
			return;
		}
		if (curr == end) {
			System.out.println(ssf + " ");
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			possiblePaths(curr + dice, end, board, ssf + board[dice]+" ");
		}
	}

	private static int[] printPrimeSOE(int n) {
		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		int primeIndex = 2;
		for (; primeIndex * primeIndex < n + 1; primeIndex++) {
			for (int i = primeIndex; primeIndex * i <= n; i++) {
				if (primes[primeIndex * i] == true) {
					primes[primeIndex * i] = false;
				}
			}
		}
		int[] rs = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		int left = 0;
		int right = primes.length - 1;
		while (left <= right) {
			while (primes[left] == false) {
				left++;
			}
			while (primes[right] == false) {
				right--;
			}
			if (left <= right) {
				rs[left] = right;
				left++;
				right--;
			}
		}
		return rs;
	}
}
