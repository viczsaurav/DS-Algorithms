package searchingSortingDataStructures;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GraphVertex<T> {
	private T label;
	private Set<GraphVertex<T>> neighbors;

	public GraphVertex(T label) {
		this.label = label;
		neighbors = new HashSet<>();
	}

	public T getLabel() {
		return this.label;
	}

	public Set<GraphVertex<T>> getNeighbors() {
		return Collections.unmodifiableSet(this.neighbors);
	}

	public void addNeighbor(GraphVertex neighbor) {
		this.neighbors.add(neighbor);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GraphVertex<?> that = (GraphVertex<?>) o;
		return Objects.equals(label, that.label);
	}

	@Override
	public int hashCode() {
		return Objects.hash(label);
	}
}
