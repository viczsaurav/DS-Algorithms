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

	public static void colorGraph(GraphNode[] graph, String[] colors) {

		// create a valid coloring for the graph


	}

}
