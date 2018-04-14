package lecture_9;

import java.util.Scanner;

public class modify1 {

	public static void main(String[] args) {
		System.out.print("Enter a string : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
//		String modified1 = modify1(str);
//		System.out.println(modified1);
		
		String compressed1 = compression1(str);
		System.out.println(compressed1);
		
//		String compressed2 = compression2(str);
//		System.out.println(compressed2);
//		
//		String modified2 = modify2(str);
//		System.out.println(modified2);
		
//		subSequence(str);
	}

	private static void subSequence(String str) {
		int limit = (1<<str.length())-1;
		int count = 0;
		while(count<=limit){
			for(int i=0; i<str.length(); i++){
				int ithbitkaMask = 1<<(str.length()-1-i);
				if((ithbitkaMask & count)!=0){
					System.out.print(str.charAt(i));
				}
			}
			System.out.println();
			count++;
		}
	}

	private static String compression2(String str) {
		StringBuilder sb = new StringBuilder();
		int count=1;
		for(int i=0; i<str.length()-1; i++){
			if(str.charAt(i)==str.charAt(i+1)){
				count++;
			}
			else {
				sb.append(str.charAt(i));
				sb.append(count);
				count=1;
			}
		}
		sb.append(str.charAt(str.length()-1));
		if(count>1){
			sb.append(count);
		}
		return sb.toString();
	}

	private static String modify2(String str) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<str.length()-1; i++){
			char oc = str.charAt(i);
			int gap = 0;
				gap = str.charAt(i+1)-str.charAt(i);
				sb.append(oc);
				sb.append(gap);
				
		}
		sb.append(str.charAt(str.length()-1));
		return sb.toString();
	}

	private static String modify1(String str) {
		StringBuilder sb = new StringBuilder(str);
		for(int i=0; i<sb.length(); i++){
			if(i%2==0){
				sb.setCharAt(i,(char)(sb.charAt(i)-1));
			}
			else{
				sb.setCharAt(i,(char)(sb.charAt(i)+1));
			}
		}
		return sb.toString();
	}
	private static String compression1(String str){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length()-1; i++){
			if(str.charAt(i)==str.charAt(i+1)){
			}
			else {
				sb.append(str.charAt(i));
			}
		}
		sb.append(str.charAt(str.length()-1));
		return sb.toString();
	}
}
