package searchingSortingDataStructures;

import java.util.*;

class Graphs<T> {

	private Set<GraphVertex<T>> graph;

	public Graphs(){
		graph = new HashSet<>();
	}

	public void addVertex(GraphVertex<T> vertex){
		this.graph.add(vertex);
	}

	public Set<GraphVertex<T>> getAllVertices(){
		return Collections.unmodifiableSet(this.graph);
	}

	public int getGraphSize(){
		return this.graph.size();
	}

	/**
	 * Ways to create Graphs => List + Adjacency List + Matrix
	 * @param args
	 */
	public static void main (String[] args) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		graph.put(0, Arrays.asList(1));
		graph.put(1, Arrays.asList(0, 2, 3));
		graph.put(2, Arrays.asList(1, 3));
		graph.put(3, Arrays.asList(1, 2));

		int[][] graphList = {{0, 1}, {1, 2}, {1, 3}, {2, 3}};

		int[][] graphAdjacencyList = {
						{1},
						{0, 2, 3},
						{1, 3},
						{1, 2}
		};
	}
}