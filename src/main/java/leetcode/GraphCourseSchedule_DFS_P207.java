package leetcode;

import java.util.*;

public class GraphCourseSchedule_DFS_P207 {
	Set<Integer> visited;
	Set<Integer> explored;
	Map<Integer, List<Integer>> courseMap;

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		visited = new HashSet<>();
		explored = new HashSet<>();
		courseMap = new HashMap<>();

		for(int i=0; i< prerequisites.length;i++){
			courseMap.putIfAbsent(prerequisites[i][0], new ArrayList<>());
			courseMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		for (Integer key : courseMap.keySet()){
			if (!visited.contains(key) ){
				if (checkCycle(key)){
					return false;
				}
			}
		}

		return true;
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
		GraphCourseSchedule_DFS_P207 graph = new GraphCourseSchedule_DFS_P207();
		int [][] pre1 = {{1,0},{0,1}};
		int num1 = 2;

		int[][] pre2 = {{1,0},{2,1}};
		int num2 = 3;

		System.out.println("Expected: false, Output: "+ graph.canFinish(num1, pre1));
		System.out.println("Expected: true, Output: "+ graph.canFinish(num2, pre2));
	}
}
