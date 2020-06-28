package leetcode;

import java.util.*;

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
		input1.add(Arrays.asList(new String[]{"JFK","KUL"}));
		input1.add(Arrays.asList(new String[]{"JFK","NRT"}));
		input1.add(Arrays.asList(new String[]{"NRT","JFK"}));

		System.out.println("Expected: [JFK, NRT, JFK, KUL] \nOutput  : "+ graph.findItinerary(input1).toString());
	}
}