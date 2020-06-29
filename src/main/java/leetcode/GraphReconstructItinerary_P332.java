package leetcode;

import java.util.*;

/**
 * O(nlogn) time complexity from PriorityQueue (Time complexity should be O(n + nlogn + n) (build graph O(n + nlogn), Hierholzer O(n)))=>
 * 		-> Inserting all the starting nodes, into the minHeap, would be in total O(nlogn) right, considering, for each insertion, take O(logn) time
 *
 * Also the recursive part would also have O(nlogn), since it would visit each node, and the estracting the minimum element from Heap and rebalancing it is in total a O(logn) operation.
 *
 *
 * O(n) space complexity from recursion (Space complexity should be O(n), where n is the total number of tickets.)
 *
 *
 *
 *
 *
 * Approach:
 *
 * All the airports are vertices and tickets are directed edges. Then all these tickets form a directed graph.
 * The graph must be Eulerian since we know that a Eulerian path exists.
 * Thus, start from "JFK", we can apply the Hierholzer's algorithm to find a Eulerian path in the graph which is a valid reconstruction.
 * Since the problem asks for lexical order smallest solution, we can put the neighbors in a min-heap. In this way, we always visit the smallest possible neighbor first in our trip.
 *
 *
 */
public class GraphReconstructItinerary_P332 {
	private Map<String, PriorityQueue<String>> adj;
	private List<String> out;
	public List<String> findItinerary(List<List<String>> tickets) {

		out = new ArrayList<>();

		if (tickets.size()==0)  return out;

		adj = new HashMap<>();

		for (List<String> edge: tickets){
			adj.putIfAbsent(edge.get(0), new PriorityQueue<>());
			adj.get(edge.get(0)).add(edge.get(1));
		}
		dfs("JFK");

		return out;
	}

	private void dfs(String src){
		PriorityQueue<String> arrivals = adj.get(src);
		while(arrivals!=null && arrivals.size()>0){
			dfs(arrivals.poll());
		}
		out.add(0,src);
	}

	public static void main(String[] args) {
		GraphReconstructItinerary_P332 graph = new GraphReconstructItinerary_P332();
		List<List<String>> input1 = new ArrayList<>();

		input1.add(Arrays.asList("JFK","KUL"));
		input1.add(Arrays.asList("JFK","NRT"));
		input1.add(Arrays.asList("NRT","JFK"));

		System.out.println("Expected: [JFK, NRT, JFK, KUL] \nOutput  : "+ graph.findItinerary(input1).toString());
	}
}