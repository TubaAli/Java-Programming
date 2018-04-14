package lecture_17;

import java.util.Arrays;
import java.util.Scanner;

public class seive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printPrimeSOE(n);
	}

	private static void printPrimeSOE(int n) {
		boolean[] primes = new boolean[n+1];
		
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		int primeIndex = 2;
		for(;primeIndex*primeIndex<n+1; primeIndex++)
		{
			for(int i=primeIndex; primeIndex*i<=n; i++){
				if(primes[primeIndex*i]==true){
					primes[primeIndex*i]=false;
				}
			}
		}
		for(int i=0; i<n+1; i++){
			if(primes[i]==true){
				System.out.print(i+" ");
			}
		}
	}

}
