package lecture_8;

import java.util.ArrayList;
import java.util.Scanner;

public class solution3 {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String str = sc.nextLine();
	        int n = str.length();
	        System.out.println(countPermutations(str,"",n));
	        System.out.println(allPermutations(str));
	        printPermutations(str,"");
	    }

	private static void printPermutations(String ques, String ans) {
		if(ques.length()==0){
			System.out.println(ans);
			return;
		}
		char ch = ques.charAt(ques.length()-1);
		String roq = ques.substring(0,ques.length()-1);
		
		for(int j=0; j<ans.length()+1; j++){
			printPermutations(roq,ans.substring(0,j)+ch+ans.substring(j));
		}
	}

	private static ArrayList<String> allPermutations(String str) {
		if(str.length()==0){
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String roq = str.substring(1);
		
		ArrayList<String> rresult = allPermutations(roq);
		ArrayList<String> mresult = new ArrayList<String>();
		
		for(String rstr: rresult){
			StringBuilder sb = new StringBuilder(rstr);
			for(int j=0; j<roq.length()+1; j++){
				sb.insert(j, ch);
				mresult.add(sb.toString());
				sb.deleteCharAt(j);
			}
		}
		return mresult;
	}
static int count = 0;
	private static int countPermutations(String ques,String ans,int n) {
		if(ques.length()==0){
			return count+=1;
		}
		
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		
		for(int j=0; j<=ans.length(); j++){
			count=countPermutations(roq,ans.substring(0,j)+ch+ans.substring(j),n);
		}
		return count;
	}
}
