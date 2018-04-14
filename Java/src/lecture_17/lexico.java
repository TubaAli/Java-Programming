package lecture_17;

public class lexico {

	public static void main(String[] args) {
		printLexi(1,100,1);
	}

	private static void printLexi(int st, int en,int i) {
		if(i<en){
			System.out.print(i+" ");
		}
		int r = en%100;
		for(int j=0; j<10; j++){
			
		}
		printLexi(st,en,r+st);
	}

}
