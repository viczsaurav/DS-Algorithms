package interviewCake;

import java.util.*;

public class MeshMessageBFS {

	/**
	 * Complexity
	 * Our solution has two main steps.
	 *  - First, we do a breadth-first search of the user network starting from the sender.
	 *  - Then, we use the results of our search to backtrack and find the shortest path.
	 *
	 * How much work is a breadth-first search?
	 *
	 * In the worst case, we'll go through the BFS loop once for every node in the graph, since we only ever add each node to nodesToVisit once (we check howWeReachedNodes to see if we've already added a node before).
	 * Each loop iteration involves a constant amount of work to dequeue the node and check if it's our end node.
	 * If we have N nodes, then this portion of the loop is O(N).
	 *
	 * But there's more to each loop iteration: we also look at the current node's neighbors.
	 * Over all of the nodes in the graph, checking the neighbors is O(M), since it involves crossing each edge twice: once for each node at either end.
	 *
	 * Putting this together, the complexity of the breadth-first search is O(N+M).
	 *
	 * BFS and DFS are common enough that it's often acceptable to just state their complexity as O(N+M).
	 * Some interviewers might want you to derive it though, so definitely be ready in case they ask.
	 *
	 * What about backtracking to determine the shortest path? Handling each node in the path is O(1), and we could have at most N nodes in our shortest path.
	 * So, that's O(N)for building up the path. Then, it's another O(N)to reverse it.
	 * So, the total time complexity of our backtracking step is O(N).
	 *
	 * Putting these together, the time complexity of our entire algorithm is O(N+M).
	 *
	 * What about space complexity?
	 * The queue of nodes to visit, the mapping of nodes to previous nodes, and the final path ...
	 * they all store a constant amount of information per node. So, each data structure could take up to O(N) space if it stored information about all of our nodes. That means our overall space complexity is O(N).
	 *
	 * @param graph
	 * @param startNode
	 * @param endNode
	 * @return
	 */


	public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

		if(!graph.containsKey(startNode) || !graph.containsKey(endNode)){
			throw new IllegalArgumentException("Nodes Missing");
		}

		Deque<String> nodes = new ArrayDeque<>();
		nodes.offerLast(startNode);

		// keep track of how we got to each node
		// we'll use this to reconstruct the shortest path at the end
		// we'll ALSO use this to keep track of which nodes we've already visited
		Map<String, String> howWeReached = new HashMap<>();
		howWeReached.put(startNode,null);

		while(!nodes.isEmpty()){
			String node = nodes.pollFirst();
			String[] neighbours = graph.get(node);

			// stop when we reach the end node
			if(node.equals(endNode)){
				return reconstructThePath(howWeReached, startNode, endNode);
			}

			for(String neighbor: neighbours){
				if(!howWeReached.containsKey(neighbor)){
					nodes.offerLast(neighbor);
					// Keep Track how we reached this node
					howWeReached.put(neighbor,node);
				}
			}
		}

		// if we get here, then we never found the end node
		// so there's NO path from startNode to endNode
		return null;
	}

	public static String[] reconstructThePath(Map<String, String> paths,String startNode, String endNode){
		List<String> shortestPath = new ArrayList<>();
		String currNode = endNode;
		while(currNode!=null){
			shortestPath.add(currNode);
			currNode = paths.get(currNode);
		}
		Collections.reverse(shortestPath);
		return shortestPath.toArray(new String[shortestPath.size()]);
	}
}
