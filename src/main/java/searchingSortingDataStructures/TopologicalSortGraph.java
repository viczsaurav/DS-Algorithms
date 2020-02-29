package searchingSortingDataStructures;

import java.util.*;

public class TopologicalSortGraph<T> {

	public void topologicalSort(Graphs<T> graph){

		// Base condition
		if (graph.getGraphSize()==0){
			throw new IllegalArgumentException("The input graph is empty");
		}

		Set<GraphVertex<T>> visited = new HashSet<>();
		Deque<GraphVertex<T>> stack = new ArrayDeque<>();

		for (GraphVertex<T> vertex: graph.getAllVertices()){
			if(visited.contains(vertex)){
				continue;
			}
			depthFirstSearch(visited, stack, vertex);
		}

		printStack(stack);

	}

	private void depthFirstSearch(Set<GraphVertex<T>> visited, Deque<GraphVertex<T>> stack, GraphVertex<T> vertex){

		// No need to break condition in recursion as function returned if last node,i.e no neighbours

		// Update Visited here, since recursion
		visited.add(vertex);

		for (GraphVertex<T> neighbour: vertex.getNeighbors()){
			if(visited.contains(neighbour))	continue;
			depthFirstSearch(visited, stack, neighbour);
		}
		stack.offerFirst(vertex);
	}

	private void printStack(Deque<GraphVertex<T>> stack){
		while(!stack.isEmpty()){
			System.out.println(stack.pollFirst().getLabel());
		}
	}

	public static void main(String [] args){
		final GraphVertex<String> nodeA = new GraphVertex("A");
		final GraphVertex<String> nodeB = new GraphVertex("B");
		final GraphVertex<String> nodeC = new GraphVertex("C");
		final GraphVertex<String> nodeD = new GraphVertex("D");
		final GraphVertex<String> nodeE = new GraphVertex("E");
		nodeA.addNeighbor(nodeB);
		nodeA.addNeighbor(nodeC);
		nodeB.addNeighbor(nodeC);
		nodeB.addNeighbor(nodeD);
		nodeB.addNeighbor(nodeE);
		nodeC.addNeighbor(nodeD);
		nodeC.addNeighbor(nodeE);
		nodeE.addNeighbor(nodeD);

		Graphs<String> graph = new Graphs();
		graph.addVertex(nodeA);
		graph.addVertex(nodeB);
		graph.addVertex(nodeC);
		graph.addVertex(nodeD);
		graph.addVertex(nodeE);

		TopologicalSortGraph topSort = new TopologicalSortGraph();
		topSort.topologicalSort(graph);
	}
}
