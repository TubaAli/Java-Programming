package lecture_17;

import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		isPalindrome(st);
	}

	private static void isPalindrome(String st) {
		int counter=0;
		for(int axis = 0; axis<st.length(); axis++){
			for(int orbit=0; axis-orbit>=0 && axis+orbit<st.length(); orbit++){
				if(st.charAt(axis-orbit)==st.charAt(axis+orbit)){
					counter++;
				}
				else{
					break;
				}
			}
		}
		for(double axis = 0.5; axis<st.length(); axis++){
			for(double orbit=0.5; axis-orbit>=0 && axis+orbit<st.length(); orbit++){
				if(st.charAt((int)(axis-orbit))==st.charAt((int)(axis+orbit))){
					counter++;
				}
				else{
					break;
				}
			}
		}
		System.out.print(counter);
	}

}
