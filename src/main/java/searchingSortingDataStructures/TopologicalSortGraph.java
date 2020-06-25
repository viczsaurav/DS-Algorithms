package searchingSortingDataStructures;

import java.util.*;

/**
 * Topological Sorting
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 *
 * For example, a topological sorting of the following graph is “5 4 2 3 1 0”. There can be more than one topological sorting for a graph. For example, another topological sorting of the following graph is “4 5 2 3 1 0”. The first vertex in topological sorting is always a vertex with in-degree as 0 (a vertex with no incoming edges).
 *
 * Graph
 *
 * 		2	<- 5 -> 0 <- 4 -> 1
 * 		 \								 /
 * 	    \ -> -> 3 <- <- /
 *
 * Topological Sorting vs Depth First Traversal (DFS):
 * In DFS, we print a vertex and then recursively call DFS for its adjacent vertices. In topological sorting, we need to print a vertex before its adjacent vertices. For example, in the given graph, the vertex ‘5’ should be printed before vertex ‘0’, but unlike DFS, the vertex ‘4’ should also be printed before vertex ‘0’. So Topological sorting is different from DFS. For example, a DFS of the shown graph is “5 2 3 1 0 4”, but it is not a topological sorting
 *
 */

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
