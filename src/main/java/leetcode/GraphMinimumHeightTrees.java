package leetcode;

import java.util.*;
/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class GraphMinimumHeightTrees {

	/**
	 https://www.youtube.com/watch?v=Bl9l5cUgTnQ

	 - Centre (of tree) => MHT's root => a node that minimizes remoteness

	 - remoteness => R(v) => v's distance from furthest node
	 => If v=root, R(v) gives the height of the tree

	 - We can hae maximum of 2 centres/MHT roots  [IMPORTANT]
	 => 2 in case of odd MAX(R(v))
	 => 1 in case of even MAX(R(v))

	 - Degree of node => the number of nodes adjacent to it
	 - Leaf (indirected graph) => degree=1

	 - Path Graph => Tree with 2 or more vertices with no branches [every node has just 1 child]
	 e.g X
	 |
	 |
	 Y
	 - Solution for above simpler case, take 2 pointers p1,p2 from the leaves on 2 sides of path graph
	 and move them simultaneously until they meet in the middle(or one-edge apart), then return 1-2 nodes


	 - Genrealize =>
	 1. Put pointer on every leaf of the graph
	 2. Move all pointers inward at same speed
	 3. When 2 pointers meet at middle or one distance apart _> keep only one of them
	 4. Keep doing 1-3, until we have only 2 pointers either at same node or 1 edge apart.

	 These 2 pointers are on the longest path in the tree(since last ones to be eliminated).
	 So its imperate to have our root as part of the longest path so that remoteness can be minimized
	 Balanced tree is the tree with min height

	 BFS => move by outer ringer leaves and move inward

	 */

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		/**
		 ArrayList<Integer>[] al = new ArrayList[n];
		 E.g representation:

		 [array] -> Arraylist
		 [0]-> [1, 2]
		 [1]-> [0]
		 [2]-> [0, 3, 5]
		 --
		 [n]-> [0, n-1]
		 */
		ArrayList<Integer>[] adj = new ArrayList[n];
		int[] degrees = new int[n];

		// Instantiating All array elements with empty list, O(n)
		for(int i=0; i < n; i++) adj[i] = new ArrayList<>();

		// For each edge in edgeList, populate the adjacency list. O(E)
		for(int[] edge: edges) {

			adj[edge[0]].add(edge[1]);   // Add to neighborList
			adj[edge[1]].add(edge[0]);   // Since undirected, so single edge should be counted for both elements

			degrees[edge[0]]++;
			degrees[edge[1]]++;

		}

		ArrayList<Integer> leaves = new ArrayList<>();

		// Initially get all the leaf nodes
		for(int i=0; i < n; i++)
			if(degrees[i] == 1) leaves.add(i);

		while(leaves.size() != 0) {

			ArrayList<Integer> next = new ArrayList<>();

			// Iterate through all the leaf nodes
			for(int leaf: leaves) {
				degrees[leaf]--;     // We are done with current leaf, so decrement the degree, as good as removing

				// Iterate through all neighbors of the leaf
				for(int neighbor: adj[leaf])
					// After looking at current leaf, remove the current leaft from its neighbor list and see if it becomes a leaf
					if(--degrees[neighbor] == 1) next.add(neighbor);
			}

			// No more leaves left
			if(next.size() == 0) return leaves;
			// else it becomes next level of leaves
			leaves = next;
		}

		leaves.add(0);  // When no leaves present/ empty graph
		return leaves;
	}

	public static void main(String[] args) {
		GraphMinimumHeightTrees graph = new GraphMinimumHeightTrees();
		int [][] pre1 = {{1,0},{1,2},{1,3}};
		int num1 = 4;

		int[][] pre2 = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		int num2 = 6;

		int[][] pre3 = {};
		int num3 = 1;

		System.out.println("Expected: [1], Output: "+ graph.findMinHeightTrees(num1, pre1).toString());
		System.out.println("Expected: [3,4], Output: "+ graph.findMinHeightTrees(num2, pre2).toString());
		System.out.println("Expected: [0], Output: "+ graph.findMinHeightTrees(num3, pre3).toString());
	}
}
