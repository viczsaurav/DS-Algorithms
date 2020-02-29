package searchingSortingDataStructures;

import java.util.*;

public class TopologicalSortGraph {

	public void topologicalSort(Graphs graph){

		// Base condition
		if (graph.getGraphSize()==0){
			throw new IllegalArgumentException("The input graph is empty");
		}

		Set<GraphVertex> visited = new HashSet<>();
		Deque<GraphVertex> stack = new ArrayDeque<>();

		for (GraphVertex vertex: graph.getAllVertices()){
			if(visited.contains(vertex)){
				continue;
			}
			depthFirstSearch(visited, stack, vertex);
		}

		printStack(stack);

	}

	private void depthFirstSearch(Set<GraphVertex> visited, Deque<GraphVertex> stack, GraphVertex vertex){

		// No need to break condition in recursion as function returned if last node,i.e no neighbours

		// Update Visited here, since recursion
		visited.add(vertex);

		for (GraphVertex neighbour: vertex.getNeighbors()){
			if(visited.contains(neighbour))	continue;
			depthFirstSearch(visited, stack, neighbour);
		}
		stack.offerFirst(vertex);
	}

	private void printStack(Deque<GraphVertex> stack){
		while(!stack.isEmpty()){
			System.out.println(stack.pollFirst().getLabel());
		}
	}

	public static void main(String [] args){
		final GraphVertex nodeA = new GraphVertex("A");
		final GraphVertex nodeB = new GraphVertex("B");
		final GraphVertex nodeC = new GraphVertex("C");
		final GraphVertex nodeD = new GraphVertex("D");
		final GraphVertex nodeE = new GraphVertex("E");
		nodeA.addNeighbor(nodeB);
		nodeA.addNeighbor(nodeC);
		nodeB.addNeighbor(nodeC);
		nodeB.addNeighbor(nodeD);
		nodeB.addNeighbor(nodeE);
		nodeC.addNeighbor(nodeD);
		nodeC.addNeighbor(nodeE);
		nodeE.addNeighbor(nodeD);

		Graphs graph = new Graphs();
		graph.addVertex(nodeA);
		graph.addVertex(nodeB);
		graph.addVertex(nodeC);
		graph.addVertex(nodeD);
		graph.addVertex(nodeE);

		TopologicalSortGraph topSort = new TopologicalSortGraph();
		topSort.topologicalSort(graph);
	}
}
