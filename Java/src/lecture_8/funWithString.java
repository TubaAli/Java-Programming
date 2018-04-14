package lecture_8;

import java.util.Scanner;

public class funWithString {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Enter the String : ");
		String str = sc.nextLine();
		printStr(str);
		printAllSubstring(str);
		reverseAllChar(str);
		String rs = reverseString(str);
		printStr(rs);
		boolean pos = isPalindrome(str);
		System.out.println(pos);
	}

	private static String reverseString(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i=str.length()-1; i>=0; i--){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	private static void printStr(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
		}
	}

	public static void printAllSubstring(String str) {

		for (int i = 0; i < str.length(); i++) {
			for (int j = i+1; j <= str.length(); j++) {
				System.out.println(str.substring(i,j));
			}
		}
	}
	public static void reverseAllChar(String str){
		for(int i = str.length()-1; i>=0; i--){
			System.out.print(str.charAt(i));
		}
	}
	
	public static boolean isPalindrome(String str){
		int left = 0, right = str.length()-1;
		for(int i=0; i<str.length()/2; i++){
			if(str.charAt(left)!=str.charAt(right))
				return false;
			
				left++;
				right--;
		}
		return true;
	}
}
