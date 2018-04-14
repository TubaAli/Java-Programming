package lecture_11;

public class MoreOnRecursion {

	public static void main(String[] args) {
		print_Triangle(1,1,5);
		printInverted_Triangle(1,1,5);
	}

	private static void printInverted_Triangle(int row, int col, int n) {
			if(row>n){
				return;
			}
			if(col>row){
				printInverted_Triangle(row+1,1,n);
				//to prevent extra enter which was appearing in beginning
				if(row!=n){
					System.out.println();
				}
				return;
			}
			printInverted_Triangle(row,col+1,n);
			System.out.print("*");
		}

	private static void print_Triangle(int row, int col, int n) {
		if(row>n){
			return;
		}
		if(col>row){
			System.out.println();
			print_Triangle(row+1,1,n);
			return;
		}
		System.out.print("*");
		print_Triangle(row,col+1,n);
	}
}
