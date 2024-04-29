package leetcode;

import java.util.*;

public class EvaluateDivision_P399_graph_dfs {
    static Map<String,List<Pair>> graph = new HashMap<>();

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] output = new double[queries.size()];


        // Create directed Graph of elements with corresponding values, e.g for both a=>b and b=>a
        int i=0;
        for (List<String> eq:equations){
            graph.computeIfAbsent(eq.get(0),k->new ArrayList<>()).add(new Pair(eq.get(0), eq.get(1),values[i]));
            graph.computeIfAbsent(eq.get(1),k->new ArrayList<>()).add(new Pair(eq.get(1), eq.get(0),1/values[i]));
            i++;
        }

        for(Map.Entry<String,List<Pair>> row: graph.entrySet()){
            System.out.print(row.getKey()+"->");
            for(Pair p: row.getValue()){
                System.out.print(p.stringify()+", ");
            }
            System.out.println(" ");

        }

        // Iterate over queries and try to find path in graph. Multiplying values along each edge will give result
        // This may require traversing all graph elements adjacency list to find final path
        int j=0;
        for (List<String> query:queries){
            Set<String> visited = new HashSet<>();
            if(!graph.containsKey(query.get(0)) || !graph.containsKey(query.get(1))){
                output[j]=-1;
            }
            else{
                output[j] = findPathValue(query.get(0), query.get(1), visited, 1.0);
            }
            j++;
        }

        return output;

    }

    private static double findPathValue(String src, String dest, Set<String> visited, double total){
        visited.add(src);
        System.out.println("src: "+src+", dest: "+ dest+ "|| "+ total);
        if(src.equals(dest)) return total;

        for(Pair p: graph.get(src)){
            System.out.println("src: "+src+", dest: "+ dest+ "|| "+ p.stringify());
            System.out.println(visited.toString());
            if(!visited.contains(p.dest)){
                double output = findPathValue(p.dest, dest, visited, p.val*total);
                System.out.println("output: "+ output);
                if(output!=-1)  return output;
            }

        }
        visited.remove(src);
        return -1;

    }

    static class Pair{
        String src;
        String dest;
        double val;

        Pair(String src, String dest, double val){
            this.src = src;
            this.dest = dest;
            this.val = val;
        }

        public String stringify(){
            return "src: "+this.src+", dest: "+this.dest+", value: "+this.val;
        }
    }

    public static void main(String[] args) {

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList(new String[]{"x1","x2"}));
        equations.add(Arrays.asList(new String[]{"x2","x3"}));
        equations.add(Arrays.asList(new String[]{"x3","x4"}));
        equations.add(Arrays.asList(new String[]{"x4","x5"}));

        double [] values = {3.0,4.0,5.0,6.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList(new String[]{"x1","x5"}));
        queries.add(Arrays.asList(new String[]{"x5","x2"}));
        queries.add(Arrays.asList(new String[]{"x2","x4"}));
        queries.add(Arrays.asList(new String[]{"x2","x2"}));
        queries.add(Arrays.asList(new String[]{"x2","x2"}));

        double [] output = calcEquation(equations,values,queries);

        double [] expected = {360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000};

        for (int i=0;i<output.length;i++){
            System.out.println("Expected:"+ expected[i] +" , output: "+ output[i]);
        }
    }
}