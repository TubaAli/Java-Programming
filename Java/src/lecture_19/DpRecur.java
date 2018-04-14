package lecture_19;

public class DpRecur {

	public static void main(String[] args) {
		int[] strg = new int[6]; 
		int n1 = FiboRI(5,strg);
		System.out.println(n1);
		int n2 = fiboItr(5);
		System.out.println(n2);
		int n3 = fiboSlider(5);
		System.out.println(n3);
	}

	private static int fiboSlider(int n) {
		int[] strg = new int[2];
		strg[0] = 0;
		strg[1] = 1;
		for(int i=0; i<n; i++){
			int newfib = strg[0]+strg[1];
			strg[0] = strg[1];
			strg[1] = newfib;
		}
		return strg[0];
	}

	private static int fiboItr(int n) {
		int[] strg = new int[n+1];
		strg[0] = 0;
		strg[1] = 1;
		for(int i=2; i<=n; i++){
			strg[i] = strg[i-1]+strg[i-2];
		}
		return strg[n];
	}

	private static int FiboRI(int n,int[] strg) {
		if(n==0 || n==1){
			return n;
		}
		if(strg[n]!=0){
			return strg[n];
		}
		int n1 = FiboRI(n-1,strg);
		int n2 = FiboRI(n-2,strg);
		int fn = n1+n2;
		
		strg[n] = fn;
		return fn;
	}

}
