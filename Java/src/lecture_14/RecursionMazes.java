package lecture_14;

public class RecursionMazes {

	public static void main(String[] args) {
//		printMazePath(0,0,2,2,"");
//		printMPWD(0,0,2,2,""); //multiple path with diagonal
		printMPWDWithMultiMoves(0,0,2,2,"");
	}

	private static void printMPWDWithMultiMoves(int row, int col, int rowmax, int colmax, String ans) {
		if(row==rowmax && col==colmax){
			System.out.print(ans+" ");
			return;
		}
		if(row>rowmax || col>colmax){
			return;
		}
		for(int i=1; i<=colmax-col; i++){
			printMPWDWithMultiMoves(row,col+i,rowmax,colmax,ans+'h'+i);
		}
		for(int i=1; i<=rowmax-row; i++){
			printMPWDWithMultiMoves(row+i,col,rowmax,colmax,ans+'v'+i);
		}
		for(int i=1; i<=rowmax-row && i<=colmax-col; i++){
			printMPWDWithMultiMoves(row+i,col+i,rowmax,colmax,ans+'d'+i);
		}
	}

	private static void printMazePath(int row, int col, int rowmax, int colmax, String ans) {
		if(row==rowmax && col==colmax){
			System.out.print(ans+" ");
			return;
		}
		if(row>rowmax){
			return;
		}
		if(col>colmax){
			return;
		}
		printMazePath(row,col+1,rowmax,colmax,ans+'h');
		printMazePath(row+1,col,rowmax,colmax,ans+'v');
	}
	
	private static void printMPWD(int row, int col, int rowmax, int colmax, String ans) {
		if(row==rowmax && col==colmax){
			System.out.print(ans+" ");
			return;
		}
		if(row>rowmax || col>colmax){
			return;
		}
		printMPWD(row,col+1,rowmax,colmax,ans+'h');
		printMPWD(row+1,col,rowmax,colmax,ans+'v');
		printMPWD(row+1,col+1,rowmax,colmax,ans+'d');
	}

}
