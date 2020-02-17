package interviewCake;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class GraphColoring {


	public static class GraphNode {

		private String label;
		private Set<GraphNode> neighbors;
		private Optional<String> color;

		public GraphNode(String label) {
			this.label = label;
			neighbors = new HashSet<GraphNode>();
			color = Optional.empty();
		}

		public String getLabel() {
			return label;
		}

		public Set<GraphNode> getNeighbors() {
			return Collections.unmodifiableSet(neighbors);
		}

		public void addNeighbor(GraphNode neighbor) {
			neighbors.add(neighbor);
		}

		public boolean hasColor() {
			return color.isPresent();
		}

		public String getColor() {
			return color.get();
		}

		public void setColor(String color) {
			this.color = Optional.ofNullable(color);
		}
	}

	/**
	 * O(N+M) time where N is the number of nodes and M is the number of edges.
	 * O(D) space
	 *
	 * The runtime might not look linear because we have outer and inner loops.
	 * The trick is to look at each step and think of things in terms of the total number of edges (M) wherever we can:
	 *
	 * We check if each node appears in its own hash set of neighbors. Checking if something is in a hash set is O(1),
	 * so doing it for all N nodes is O(N).
	 *
	 * When we get the illegal colors for each node, we iterate through that node's neighbors.
	 * So in total, we cross each of the graphs M edges twice: once for the node on either end of each edge. O(M) time.
	 *
	 * When we assign a color to each node, we're careful to stop checking colors as soon as we find one that works.
	 * In the worst case, we'll have to check one more color than the total number of neighbors.
	 *
	 * Again, each edge in the graph adds two neighbors —> one for the node on either end—so there are 2*M neighbors.
	 * So, in total, we'll have to try O(N+M) colors.
	 *
	 * Putting all the steps together, our complexity is O(N+M).
	 *
	 * What about space complexity? The only thing we're storing is the illegalColors hash set.
	 * In the worst case, all the neighbors of a node with the maximum degree (D) have different colors,
	 * so our hash set takes up O(D) space.
	 *
	 *
	 * @param graph
	 * @param colors
	 */

	public static void colorGraph(GraphNode[] graph, String[] colors) {

		for (GraphNode node : graph) {

			Set<GraphNode> neighbors = node.getNeighbors();
			if (neighbors.contains(node)) {
				throw new IllegalArgumentException("The node has loop: " + node.getLabel());
			}

			// get the node's neighbors' colors, as a set so we
			// can check if a color is illegal in constant time
			Set<String> illegalColors = new HashSet<>();
			for (GraphNode neighbor : neighbors) {
				if (neighbor.hasColor())
					illegalColors.add(neighbor.getColor());
			}

			// assign the first legal color
			for (String color : colors) {
				if (!illegalColors.contains(color)) {
					node.setColor(color);
					break;      // To reduce the running time
				}
			}
		}
	}
}
