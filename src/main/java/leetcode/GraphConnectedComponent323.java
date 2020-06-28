package leetcode;

import java.util.*;

public class GraphConnectedComponent323 {

	private Map<Integer, Integer> parent;
	private List<Integer>[] adj;
	public int countComponents(int n, int[][] edges){

		if(edges.length==0)	return 0;

		adj = new ArrayList[n];
		parent = new HashMap<>();

		// Initialization
		for(int i=0; i<n;i++) {
			parent.put(i, i);
			adj[i] = new ArrayList<>();
		}

		for(int i=0; i<edges.length;i++){
			adj[edges[i][0]].add(edges[i][1]);
			adj[edges[i][1]].add(edges[i][0]);
		}

		return countByUnionFind(n);

	}

	private int countByUnionFind(int n) {
		for (int i=0; i<n;i++){
			for (int neighbor: adj[i]){
				union(i, neighbor);
			}
		}

//		parent.forEach((k,v)-> System.out.println(k +" => "+ v));

		return new HashSet<>(parent.values()).size();
	}

	private void union(int node, int neighbor) {
		if (parent.get(neighbor) == neighbor){
			parent.put(neighbor, parent.get(node));
		}
		else {
			parent.put(neighbor, parent.get(parent.get(neighbor)));
		}
	}

	/**
	 * Using Depth First Search
	 */
	List<Integer> visited;
	Set<Integer> parents;
	private int countByDFS(int n){

		visited =  new ArrayList<>();
		parents =  new HashSet<>();

		for (int i=0; i< n;i++){
			if(!visited.contains(i)){
				dfs(i);
			}
		}
		return parents.size();
	}

	private void dfs(int node){
		visited.add(node);

		for (int neighbor: adj[node]){
			if (!visited.contains(neighbor)){
				//TODO
			}
		}

	}

	public static void main(String[] args) {
		GraphConnectedComponent323 graph = new GraphConnectedComponent323();
		int [][] pre1 = {{0,1},{1,2},{3,4}};
		int num1 = 5;

		int[][] pre2 = {{2, 3}, {0, 1}, {1, 2}, {3, 4}};
		int num2 = 5;

		int[][] pre3 = {};
		int num3 = 1;

		System.out.println("Expected: 2, Output: "+ graph.countComponents(num1, pre1));
		System.out.println("Expected: 1, Output: "+ graph.countComponents(num2, pre2));
//		System.out.println("Expected: [0], Output: "+ graph.countComponents(num3, pre3));
	}
}
