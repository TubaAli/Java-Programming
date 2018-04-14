package lecture_18;

import java.util.Arrays;
import java.util.Scanner;

public class SnakenLadder {

	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		int[] moves = { 3, 2, 4, 6, 3, 6, 4 };
		//int n = sc.nextInt();
		int[] parr = printPrimeSOE(20);
		playGame(moves, parr);
	}

	private static void playGame(int[] moves, int[] parr) {
		int pos = 0;
		for (int k = 0; k < moves.length; k++) {
			if (pos + moves[k] < parr.length) {
				pos += moves[k];
			}
			if (pos == parr.length - 1) {
				System.out.print(true);
				break;
			}
			if(parr[pos]!=0){
				pos=parr[pos];
			}
		}
		System.out.print(pos);
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
		int ls = 0;
		while (left <= right) {
			while (primes[left] == false) {
				left++;
			}
			while (primes[right] == false) {
				right--;
			}
			if (left <= right) {
				if (ls % 2 == 0) {
					rs[left] = right;
					left++;
					right--;
					ls++;
				} else {
					rs[right] = left;
					left++;
					right--;
					ls++;
				}
			}
		}
		return rs;
	}
}
