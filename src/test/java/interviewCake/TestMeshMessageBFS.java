package interviewCake;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static interviewCake.MeshMessageBFS.getPath;
import static org.junit.jupiter.api.Assertions.*;

public class TestMeshMessageBFS {

	// tests

	@Test
	public void twoHopPath1Test() {
		final String[] expected = {"a", "c", "e"};
		final String[] actual = getPath(getNetwork(), "a", "e");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void twoHopPath2Test() {
		final String[] expected = {"d", "a", "c"};
		final String[] actual = getPath(getNetwork(), "d", "c");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneHopPath1Test() {
		final String[] expected = {"a", "c"};
		final String[] actual = getPath(getNetwork(), "a", "c");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneHopPath2Test() {
		final String[] expected = {"f", "g"};
		final String[] actual = getPath(getNetwork(), "f", "g");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneHopPath3Test() {
		final String[] expected = {"g", "f"};
		final String[] actual = getPath(getNetwork(), "g", "f");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void zeroHopPath() {
		final String[] expected = {"a"};
		final String[] actual = getPath(getNetwork(), "a", "a");
		assertNotNull(actual);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void noPathTest() {
		final String[] actual = getPath(getNetwork(), "a", "f");
		assertNull(actual);
	}

	@Test
	public void startNodeNotPresentTest() {
		assertThrows(Exception.class,
								() -> getPath(getNetwork(), "h", "a"));
	}

	@Test
	public void endNodeNotPresentTest() {
		assertThrows(Exception.class,
						()-> getPath(getNetwork(), "a", "h"));
	}

	private static Map<String, String[]> getNetwork() {
		return new HashMap<String, String[]>() { {
			put("a", new String[] {"b", "c", "d"});
			put("b", new String[] {"a", "d"});
			put("c", new String[] {"a", "e"});
			put("d", new String[] {"a", "b"});
			put("e", new String[] {"c"});
			put("f", new String[] {"g"});
			put("g", new String[] {"f"});
		}};
	}
}
