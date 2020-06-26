package leetcode;

import java.util.*;

public class CloneGraph {
	Map<Node, Node> cloneMap;

	public Node cloneGraphDFS(Node node) {
		cloneMap = new HashMap<>();
		return createClone(node);
	}

	/**
	 * Depth First Search
	 * @param node
	 * @return
	 */
	public Node createClone(Node node){
		if(node==null)  return null;
		Node clone = new Node(node.val);
		cloneMap.put(node, clone);
		clone.neighbors = getClonedNeighbors(node);
		return clone;
	}

	public List<Node> getClonedNeighbors(Node node){
		List<Node> neighbors = new ArrayList<>();
		for(Node n: node.neighbors){
			if (cloneMap.containsKey(n)){
				neighbors.add(cloneMap.get(n));
			}
			else {
				neighbors.add(createClone(n));
			}
		}
		return neighbors;
	}

	/**
	 *
	 * Breadth First
	 * @param root
	 * @return
	 */
	public Node cloneGraphBFS(Node root) {
		if (root == null)
			return root;

		Map<Node, Node> cloneMap = new HashMap<>();
		Deque<Node> queue = new ArrayDeque<>();
		queue.offerLast(root);

		cloneMap.put(root, new Node(root.val));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			Node clone = cloneMap.get(node);
			for (Node n : node.neighbors) {
				if (!cloneMap.containsKey(n)) {
					cloneMap.put(n, new Node(n.val));
					queue.offerLast(n);
				}
				clone.neighbors.add(cloneMap.get(n));
			}
		}

		return cloneMap.get(root);
	}
}


class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}