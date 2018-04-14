package practise_package;

import java.util.Scanner;

public class LargestInRect {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] mat = new int[4][7];
		for(int i=0; i<t; i++){
			int r = sc.nextInt();
			int c = sc.nextInt();
			fillMatrix(mat,r,c);
		}
		int max = -1000;
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){
				if(mat[i][j]>max){
					max = mat[i][j];
				}
			}
		}
		int count = 0;
		for(int i=0; i<mat.length; i++){
			for(int j=0; j<mat[0].length; j++){
				if(mat[i][j]==max){
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static void fillMatrix(int[][] mat, int r, int c) {
		for(int i=r-1; i>=0; i--){
			for(int j=c-1; j>=0; j--){
				mat[i][j]+=1;
			}
		}
	}

}
