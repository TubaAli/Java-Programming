
public class dijkstraAlgo {

	public static void main(String[] args) {
		int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
           };
           dijkstraAlgo d = new dijkstraAlgo();
           d.dijkstra(graph,0);
	}

	private void dijkstra(int[][] graph, int src) {
		int dist[] = new int[graph.length];
		boolean set[] = new boolean[graph.length];
		for(int i=0; i<dist.length; i++){
			dist[i] = Integer.MAX_VALUE;
			set[i] = false;
		}
		dist[0] = 0;
		for(int i=0; i<dist.length-1; i++){
			int u = minDist(dist,set);
			set[u] = true;
			
			for(int v=0; v<dist.length; v++){
				 if (!set[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE &&
	                        dist[u]+graph[u][v] < dist[v])
	                    dist[v] = dist[u] + graph[u][v];
			}
		}
		printSol(dist);
	}

	private int minDist(int[] dist, boolean[] set) {
		int min = Integer.MAX_VALUE, min_ind = -1;
		for(int v=0; v<dist.length; v++){
			if(set[v]==false && dist[v]<=min){
				min = dist[v];
				min_ind = v;
			}
		}
		return min_ind;
	}

	private void printSol(int[] dist) {
		for(int i=0;  i<dist.length; i++){
			System.out.println(dist[i]+"  "+i);
		}
	}
}
