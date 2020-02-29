package searchingSortingDataStructures;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GraphNode {
	private String label;
	private Set<GraphNode> neighbors;

	public GraphNode(String label) {
		this.label = label;
		neighbors = new HashSet<>();
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GraphNode graphNode = (GraphNode) o;
		return Objects.equals(label, graphNode.label);
	}

	@Override
	public int hashCode() {
		return Objects.hash(label);
	}
}
