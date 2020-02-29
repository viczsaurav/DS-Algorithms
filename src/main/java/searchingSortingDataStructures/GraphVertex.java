package searchingSortingDataStructures;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GraphVertex {
	private String label;
	private Set<GraphVertex> neighbors;

	public GraphVertex(String label) {
		this.label = label;
		neighbors = new HashSet<>();
	}

	public String getLabel() {
		return label;
	}

	public Set<GraphVertex> getNeighbors() {
		return Collections.unmodifiableSet(neighbors);
	}

	public void addNeighbor(GraphVertex neighbor) {
		neighbors.add(neighbor);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GraphVertex graphVertex = (GraphVertex) o;
		return Objects.equals(label, graphVertex.label);
	}

	@Override
	public int hashCode() {
		return Objects.hash(label);
	}
}
