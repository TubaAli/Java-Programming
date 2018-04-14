package lecture_2;

public class sumOfStrings {

	public static void main(String[] args) {
		String s1 = "64637";
		String s2 = "11743";
		addStrings(s1,s2);
	}

	private static void addStrings(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		if(n1>n2){
			addStrings(s2,s1);
		}
		StringBuilder s3 = new StringBuilder();
		int carry = 0;
		for(int i=n1-1; i>=0; i--){
			int num = s1.charAt(i)-'0'+s2.charAt(i+n2-n1)-'0'+carry;
			carry = num/10;
			s3.append(num%10);
		}
		for(int i=n2-n1-1;i>=0;i--){
			int num = s2.charAt(i)-'0'+carry;
			carry = num/10;
			s3.append(num%10);
		}
		if(carry!=0){
			int num = carry;
			s3.append(num);
		}
		System.out.print(s3.reverse().toString());
	}
}
