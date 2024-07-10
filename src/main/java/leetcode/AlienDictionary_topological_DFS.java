package leetcode;

import java.util.*;

public class AlienDictionary_topological_DFS {

    // For Topological sort
    Stack<Character> stack = new Stack<>();
    Set<Character> visited =  new HashSet<>();
    Set<Character> visiting =  new HashSet<>();

    public String findOrder(String [] dict, int N, int K)
    {
        //  Create Adjacency list
        Map<Character, List<Character>> graph =  new HashMap<>();

        for (String word: dict){
            for(char c : word.toCharArray()){
                graph.put(c,new ArrayList<>());
            }
        }


        // Build graph
        for(int idx=0; idx<N-1;idx++){
            String word1 = dict[idx];
            String word2 = dict[idx+1];

            //only traverse to the minlength
            int minLen = Math.min(word1.length(), word2.length());

            for(int i=0;i<minLen;i++){
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(i);

                if(c1!=c2){
                    graph.get(c1).add(c2);
                    break;
                }
            }
        }

        //Solve using Topological sort

        // Solving using DFS
        for (Character  c: graph.keySet()){
            if(!visited.contains(c)){
                dfs(c,graph);
            }
        }

        // Create ordered output TODO
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.toString();

    }

    public void dfs(Character c, Map<Character, List<Character>> graph){
        visited.add(c);
        visiting.add(c);

        if (graph.containsKey(c)){
            for(Character adj: graph.get(c)){
                if(visiting.contains(adj)){
                    throw new IllegalArgumentException("Cycle detected");
                }
                if(!visited.contains(adj)){
                    dfs(adj,graph);
                }

            }
        }

        visiting.remove(c);
        stack.push(c);
    }
}
