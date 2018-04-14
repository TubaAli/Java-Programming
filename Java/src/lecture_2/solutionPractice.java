package lecture_2;

import java.util.*;

public class solutionPractice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] qb = new int[n][m];
        System.out.println(mssmm(arr,0,0,qb));
    }
    
     static int max = Integer.MIN_VALUE;
     public static int mssmm(int[][] mat, int sr, int sc, int[][] qb){
         if(sr==mat.length-1 || sc==mat[0].length-1){
             return mat[sr][sc];
         }
         if(mat[sr][sc]==0) {
             return 0;
         }
         else{
            int maxval = Math.min(mssmm(mat,sr+1,sc,qb),Math.min(mssmm(mat,sr,sc+1,qb),mssmm(mat,sr+1,sc+1,qb)))+1;
             if(maxval>max){
                 max = maxval;
             }
             return maxval;
         }
    }
}
