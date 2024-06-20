package leetcode;
import java.util.*;

public class GraphCourseSchedule_BFS_Kahn_Topological_P207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        /** Kahn's Algo using Queue + BFS
         1. Maintain the adjacency list from prerequisite -> course
         2. Maintain indegree(incoming links) for course
         3. Start with courses which has no dependencies, i.e indegree[course]=0
         4. Keep working towards prerequisites(adjacency list values) by removing older courses with no dependencies.
         5. Add the older cources being removed to another List 'ans'
         5. We find cycle or unreachable node if:
         - At the end if there are still courses in indegree which values > 0; OR
         - ans.size() !=  numCourses
         */

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] indegree = new int[numCourses];
        List<Integer> ans = new ArrayList<>();

        //Populate adjaceny List and indegree
        for(int[] edge: prerequisites){
            int course = edge[0];
            int prerequisite =  edge[1];
            // adjacency list from prerequisite -> course
            adjList.computeIfAbsent(prerequisite, k -> new ArrayList<>()).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) queue.offer(i);
        }

        while(queue.size()!=0){
            int curr =  queue.poll();
            ans.add(curr);

            if(adjList.get(curr)!=null){
                for(int next: adjList.get(curr)){
                    indegree[next]--;
                    if(indegree[next]==0) queue.offer(next);
                }
            }
        }
        return ans.size()==numCourses;
    }

    public static void main(String[] args) {
        GraphCourseSchedule_BFS_Kahn_Topological_P207 graph = new GraphCourseSchedule_BFS_Kahn_Topological_P207();
        int [][] pre1 = {{1,0},{0,1}};
        int num1 = 2;

        int[][] pre2 = {{1,0},{2,1}};
        int num2 = 3;

        System.out.println("Expected: false, Output: "+ graph.canFinish(num1, pre1));
        System.out.println("Expected: true, Output: "+ graph.canFinish(num2, pre2));
    }
}
