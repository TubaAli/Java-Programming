package lecture_14;

import java.util.Scanner;

public class RecursionWithArrayList2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String quest = sc.nextLine();
		String asf = sc.nextLine();
//		printSubsequences(quest,asf);
//		printSSAscii(quest,asf);
		printBoardPath(0,10,asf);
		//printKPC(quest, asf);
//		printPermutation(quest,asf);
	}
	static String[] code = { "?", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuvw", "xyz", "*." };
	private static void printKPC(String quest, String asf) {
		if(quest.length()==0){
			System.out.println(asf);
			return;
		}
		char ch = quest.charAt(0);
		String roq = quest.substring(1);
		
		for (int i = 0; i < code[ch - '0'].length(); i++){
			printKPC(roq,asf+code[ch - '0'].charAt(i));
		}
	}

	private static void printPermutation(String quest, String asf) {
		if(quest.length()==0){
			System.out.println(asf+" ");
			return;
		}
		char ch = quest.charAt(0);
		String roq = quest.substring(1);
		
		for(int i=0; i<=asf.length(); i++){
				printPermutation(roq, asf.substring(0,i)+ch+asf.substring(i));
			}
		}

	private static void printBoardPath(int cur, int end, String asf) {
		if(cur>end){
			return;
		}
		if(cur==end){
			System.out.print(asf+" ");
			return;
		}
		for(int i=1; i<=6; i++){
			printBoardPath(cur+i, end, asf+i);
		}
	}

	private static void printSSAscii(String quest, String asf) {
		if(quest.length()==0){
			System.out.print(asf+" ");
			return;
		}
		char ch = quest.charAt(0);
		String roq = quest.substring(1);
		printSSAscii(roq, asf+"");
		printSSAscii(roq, asf+ch);
		printSSAscii(roq, asf+(int)ch);
	}

	private static void printSubsequences(String quest, String asf) {
		if(quest.length()==0){
			System.out.print(asf+" ");
			return;
		}
		char ch = quest.charAt(0);
		String roq = quest.substring(1);
		printSubsequences(roq, asf+"");
		printSubsequences(roq,asf+ch);
	}

}
