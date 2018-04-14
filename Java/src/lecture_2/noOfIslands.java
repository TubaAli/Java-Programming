#include<bits/stdc++.h>
using namespace std;

#define COL 5
#define ROW 5
int isSafe(int M[][COL], int row, int col, bool visited[][COL]){
    // row number is in range, column number is in range and value is 1 
    // and not yet visited
    return (row>=0 && row<ROW) && (col>=0 && col<COL) && (M[row][col] && !visited[row][col]);
}
void DFS(int M[][COL], int row, int col, bool visited[][COL]){
    // These arrays are used to get row and column numbers of 8 neighbours 
    // of a given cell
    static int rowN[] = {-1,-1,-1,0,0,1,1,1};
    static int colN[] = {-1,0,1,-1,1,-1,0,1};
    
     // Mark this cell as visited
    visited[row][col]=true;
    
    // Recur for all connected neighbours
    for(int k=0; k<8; k++){
        if(isSafe(M, row+rowN[k], col+colN[k], visited))
            DFS(M,row+rowN[k], col+colN[k], visited);
    }
}
int countIslands(int M[][COL]){
    bool visited[ROW][COL];
    memset(visited,0,sizeof(visited));
    
    int count = 0;
    for(int i=0; i<ROW; i++)
        for(int j=0; j<COL; j++)
            if(M[i][j] && !visited[i][j]){     // If a cell with value 1 is not visited yet,then new island is found
                DFS(M,i,j,visited);            // Visit all cells in this island.
                ++count;                       // increment count
            }
    return count;
}
int main()
{
    int M[][COL]= {  {1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {0, 0, 1, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}
    };
 
    printf("Number of islands is: %d\n", countIslands(M));
 
    return 0;
}