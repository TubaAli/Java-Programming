package lecture_9;

import java.util.Scanner;

public class stuffWithStringBuilder {

	public static void main(String[] args) {
		System.out.print("Enter a string : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		String toggled = toggleCase(str);
	    System.out.println(toggled);
	}
	private static String toggleCase(String str) {
		StringBuilder sb = new StringBuilder(str);
		
		for(int i=0; i<sb.length(); i++){
			if(sb.charAt(i)>='a' && sb.charAt(i)<='z'){
				sb.setCharAt(i,(char)(sb.charAt(i)-'a'+'A'));
			}
			else if(sb.charAt(i)>='A' && sb.charAt(i)<='Z'){
				sb.setCharAt(i,(char)(sb.charAt(i)-'A'+'a'));
			}
		}
		String s = sb.toString();
		return s;
	}
}
