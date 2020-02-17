package interviewCake;

import java.util.*;

public class MeshMessageBFS {


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

		Map<String, String> howWeReached = new HashMap<>();
		howWeReached.put(startNode,null);

		while(!nodes.isEmpty()){
			String node = nodes.pollFirst();
			String[] neighbours = graph.get(node);

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
