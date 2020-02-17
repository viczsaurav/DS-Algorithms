package interviewCake;

import java.util.*;

public class MeshMessageBFS {

	// TODO remove Visited and use howWeReached keyset to check
	public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

		if(!graph.containsKey(startNode) ||
						!graph.containsKey(endNode)){
			throw new IllegalArgumentException("Nodes Missing");
		}

		if (startNode.equals(endNode)){
			String[] result = {startNode};
			return result;
		}


		Deque<String> nodes = new ArrayDeque<>();
		nodes.offerLast(startNode);

		Set<String> visited = new HashSet<>();
		visited.add(startNode);

		Map<String, String> howWeReached = new HashMap<>();

		while(!nodes.isEmpty()){
			String node = nodes.pollFirst();
			String[] neighbours = graph.get(node);

			visited.add(node);

			if(node.equals(endNode)){
				return reconstructThePath(howWeReached, startNode, endNode);
			}

			for(String neighbor: neighbours){
				if(!visited.contains(neighbor)){
					nodes.offerLast(neighbor);
					visited.add(neighbor);
					// Keep Track how we reached this node
					howWeReached.put(neighbor,node);
				}
			}
		}

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
