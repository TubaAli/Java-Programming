package lecture_19;

public class boardPath {

	public static void main(String[] args) {
		int[] strg = new int[11];
//		int n1 = cbp(0,10);
//		System.out.print(n1);
//		int n2 = cbpSlider(0,10);
//		System.out.println(n2);
		int n3 = cbpRecur(0,10,strg);
		System.out.println(n3);
	}
	
	private static int cbpRecur(int curr, int end,int[] strg) {
		if(curr>end){
			return 0;
		}
		if(curr==end){
			return 1;
		}
		if(strg[curr]!=0){
			return strg[curr];
		}
		int count = 0;
		for(int dice=1; dice<=6; dice++){
			if(curr+dice<=end){
				count+=cbpRecur(curr+dice,end,strg);
			}
			strg[curr] = count;
		}
		return count;
	}

	private static int cbpSlider(int curr, int end) {
		int[] strg = new int[6];
		
		for(int i=0; i<strg.length; i++){
			strg[i] = 0;
		}
		strg[0] = 1;
		for(int i=end-1; i>=0; i--){
			int newval = strg[0]+strg[1]+strg[2]+strg[3]+strg[4]+strg[5];
			strg[5]=strg[4];
			strg[4]=strg[3];
			strg[3]=strg[2];
			strg[2]=strg[1];
			strg[1]=strg[0];
			strg[0] = newval;
		}
		return strg[0];
	}

	public static int cbp(int curr, int end){
		int[] strg = new int[end+6];
		
		strg[end] = 1;
		for(int i=end-1; i>=0; i--){
			for(int dice=1; dice<=6; dice++){
				if(i+dice<=end){
					strg[i] += strg[i+dice];
				}
			}
		}
		return strg[0];
	}
}
