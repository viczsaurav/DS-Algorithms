package leetcode;

import java.util.*;

public class Graph_DFS_BiPartite_P785 {
/**
    https://www.youtube.com/watch?v=0ACfAqs8mm0
    https://leetcode.com/problems/is-graph-bipartite/discuss/709493/DFS-Clean-Solution-with-Explaination

    2 important concepts here:
    - In bi-partite graph, the number of edges should be even
    - Using graph coloring, all nodes connected to a vertex should be of opposite color

 We have used only 2-color method because this is used to find if we have an ODD cycle length or an EVEN cycle length.Since,
 a bipartite graph never have an ODD length cycle, so, if we find any ODD length cycle then the graph will not be bipartite
*/

	int[] nodeColor;
	boolean[] visited;

	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		nodeColor = new int[n];
		visited = new boolean[n];

		Arrays.fill(nodeColor,-1);

		// graph here is already provided as Adjacency list
		// where index is node and value are neighbors
		for(int i=0; i<n;i++){
			// We iterate over full list so that we do not miss any disjoint graph sets
			if(!visited[i] && !callDfs(i, 0, graph)){
				return false;
			}
		}
		return true;
	}

	// Mark and check the color of adjacent nodes of vertex.
	// If any of same color as the node, return false else true
	private boolean callDfs(int i, int color, int[][] graph){
		nodeColor[i] = color;
		visited[i] = true;

		for (int v: graph[i]){
			// If not visited yet, continue coloring
			if(!visited[v]){
				if(!callDfs(v, color^1,graph)){
					return false;
				}
			}
			// If visited, check that this neighbor color should be different
			else {
				if (nodeColor[i]==nodeColor[v]){
					return false;
				}
			}
		}
		return true;
	}
}
