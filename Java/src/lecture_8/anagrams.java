package lecture_8;

import java.util.Scanner;

public class anagrams {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++){
			String str = sc.nextLine();
			String s = sc.nextLine();
			findAnagrams(str,s);
		}
	}

	private static void findAnagrams(String str, String s) {
		
	}

}
