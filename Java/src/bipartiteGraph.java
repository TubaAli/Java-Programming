import java.util.LinkedList;

public class bipartiteGraph {

	public static void main(String[] args) {
		int G[][] = {{0, 1, 0, 1},
	            {1, 0, 1, 0},
	            {0, 1, 0, 1},
	            {1, 0, 1, 0}
	        };
		bipartiteGraph b = new bipartiteGraph();
		if(b.isBipartite(G,0))
			System.out.println("yes");
		else System.out.println("no");
	}

	private boolean isBipartite(int[][] g, int src) {
		int[] colorArr = new int[g.length];
		for(int i=0; i<g.length; i++){
			colorArr[i] = -1;
		}
		colorArr[0] = 1;
		LinkedList<Integer>q = new LinkedList<Integer>();
        q.add(src);
        
        while(q.size()!=0){
        	int u = q.pop();
        	if(g[u][u]==1)
        		return false;
        	for(int v=0; v<g.length; v++){
        		if(g[u][v]==1 && colorArr[v]==-1){
        			colorArr[v] = 1-colorArr[u];
        			q.add(v);
        		}
        		else if(g[u][v]==1 && colorArr[v]==colorArr[u])
        			return false;
        	}
        }
		return true;
	}
}
