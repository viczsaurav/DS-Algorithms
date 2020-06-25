package amazon;

import java.util.*;

public interface Dao<T, Id> {

	boolean find(Id id) throws Exception;

	boolean add(T o) throws Exception;

	boolean update(T o) throws Exception;

	boolean delete(Id id) throws Exception;

}
