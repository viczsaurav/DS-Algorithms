package leetcode;

import java.util.*;

/**
 * Time complexity =>  O(V+E) => V= vertices , E =edges(neighbors)
 * Space Complexity => O(V+E) => We store adjacency list
 */
public class GraphCourseSchedule2 {
	Set<Integer> visited;
	List<Integer> explored;
	Map<Integer, List<Integer>> courseMap;


	public List<Integer> canFinish(int numCourses, int[][] prerequisites) {
		visited = new HashSet<>();
		explored = new ArrayList<>();
		courseMap = new HashMap<>();

		for(int i=0; i< prerequisites.length;i++){
			List<Integer> neighbors= courseMap.getOrDefault(prerequisites[i][0], new ArrayList<>());
			neighbors.add(prerequisites[i][1]);
			courseMap.put(prerequisites[i][0], neighbors);
		}

		for (Integer key : courseMap.keySet()){
			if (!visited.contains(key) ){
				if (checkCycle(key)){
					return (new ArrayList<>());
				}
			}
		}

		/**
		 * The change from GraphCourseSchedule - We have to now return the list of courses in proper order
		 * Typical case of Topological sort -  The runtime is not
		 */
		while(numCourses>0){
			int course = --numCourses;
			if (!explored.contains(course)){
				explored.add(0,course);
			}
		}

		return explored;

//		return explored.stream().mapToInt(Integer::intValue).toArray();
	}


	public boolean checkCycle(int node){
		visited.add(node);

		for (Integer nei: courseMap.getOrDefault(node, new ArrayList<>())){
			if (!visited.contains(nei)){
				if(checkCycle(nei))		return true;		// return true when true, else proceed to add to `explored` Set
			}
			else if(!explored.contains(nei))   {
				return true;    // found cycle
			}
		}
		explored.add(node);
		return false;
	}

	public static void main(String[] args) {
		GraphCourseSchedule2 graph = new GraphCourseSchedule2();
		int [][] pre1 = {{1,0},{2,0},{3,1},{3,2}};
		int num1 = 4;

		int[][] pre2 = {{1,0}};
		int num2 = 2;

		System.out.println("Expected: [0,1,2,3] or [0,2,1,3], Output: "+ graph.canFinish(num1, pre1).toString());
		System.out.println("Expected: [0,1], Output: "+ graph.canFinish(num2, pre2).toString());
	}
}
