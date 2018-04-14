package lecture_8;

import java.util.Scanner;

public class solution2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
	    if(str1.length()>str2.length()){
	    	checkPalindrome(str1,str2);
	    } else{
	    	checkPalindrome(str2,str1);
	    }
	}

	private static void checkPalindrome(String s1, String s2) {
		int i=0, j=0;
		while(i<s1.length() && j<s2.length()){
			if(s1.charAt(i)==s2.charAt(j)){
				i++;
				j++;
			}
			else{
				i++;
			}
		}
		if(j!=s2.length()){
			System.out.print("Not palindrome");
		}
		else{
			System.out.print("is Palindrome");
		}
	}
}
