
/**
 * Julia is planning a long vacation in different cities and wants to know whether a path exists between two cities. There are n cities numbered from 1 to n. 
 * Two cities, x and y, are connected by a bidirectional road if and only if gcd(x, y) > g, where gcd is the greatest common divisor of x and y. 
 * You are helping Julia find whether a path exists from city x to city y.

	Complete the connectedCities function; it has four parameters:

	Name				Type			Description
	-----   			-----   		------------
	n					integer			The number of cities.
	g					integer			Cities x and y are connected if and only if gcd(x, y) > g.
	originCities		integer array	Each index i (where 0 ≤ i ≤ q) describes x for the ith pair of cities.
	destinationCities	integer array	Each index i (where 0 ≤ i ≤ q) describes y for the ith pair of cities.

	The function must return an array of q integers where the value at each index i (where 0 ≤ i < q) is 1 if a path exists 
	from city originCitiesi to city destinationCitiesi; otherwise, it's 0 instead.

	Input Format

	The first line contains an integer denoting n.
	The second line contains an integer denoting g.
	The third line contains an integer, q, denoting the total number of elements in originCities.
	Each line i of q subsequent lines (where i ≤ 0 < q) contains an integer describing originCitiesi.
	The next line contains an integer, q, denoting the total number of elements in destinationCities.
	Each line i of q subsequent lines (where i ≤ 0 < q) contains an integer describing destinationCitiesi.

	Constraints
	=============
	2 ≤ n ≤ 2 × 105
	0 ≤ g ≤ n
	1 ≤ q ≤ min(n × (n - 1) / 2, 105)
	1 ≤ originCitiesi, destinationCitiesi ≤ n, where 0 ≤ i < q
	originCitiesi ≠ destinationCitiesi, where 0 ≤ i < q
	
	Output Format
	==============
	Return an array of q integers where the value at each index i (where 0 ≤ i < q) is 1 if a path exists from city originCitiesi to city destinationCitiesi; 
	otherwise, it's 0 instead.
	
	Sample Input
	==============
	6
	1
	4
	1
	2
	4
	6
	4
	3
	3
	3
	4
	
	Sample Output
	==============
	0
	1
	1
	1
	
	Explanation
	============
	There are n = 6 cities and, given g = 1, we know that two cities x and y are connected if and only if gcd(x, y) > 1. 
	Julia wants to know whether any path exists from:

		City 1 to city 3
		City 2 to city 3
		City 4 to city 3
		City 6 to city 4

	Let the return array be paths, then:

		paths0 = 0 because it's impossible to reach any city from city 1.
		paths1 = 1 because a path exists from city 2 to city 3. Julia can follow path 2 → 6 → 3.
		paths2 = 1 because a path exists from city 4 to city 3. Julia can follow path 4 → 6 → 3.
		paths3 = 1 because a path exists from city 6 to city 4. Julia can follow path 6 → 4.
		
	Thus, we return paths = [0, 1, 1, 1] as our answer.
 * 
 * @author Saurav
 *
 */
public class ConnectedPaths {

	public static void main(String[] args) {
		int numCities = 6;
		int gcd = 1;
		int[] origin = {1,2,4,6};
		int[] dest = {3,3,3,4};
		System.out.println("Expected: 0,1,1,1");
		int[] isConn = connectedCities(numCities,gcd,origin,dest);
		System.out.println();
		printArray("Output", isConn);
	}

    /*
     * Complete the function below.
     */
    static int[] connectedCities(int n, int g, int[] originCities, int[] destinationCities) {
        int[] isConn = new int[originCities.length];
        
        int[] parent= new int[n+1];
        for (int i=0;i<=n;i++)   parent[i]=i;
        
        for (int i=1;i<=n;i++ ){
            for (int j=i;j<=n;j++){
                union(i,j,g,parent);
            }
        }
        
        printArray("Parent", parent);
        
        for (int i=0;i<originCities.length;i++){
            int src = originCities[i];
            int dest = destinationCities[i];
            
            if (parent[src]==parent[dest]) {
                isConn[i]=1;
            }
        }
        return isConn;
    }
    
    static int gcd(int x, int y){
        if (x==0||y==0) return x+y;
        return gcd(x,x%y);
    }

    static void union(int x, int y,int g, int[] parent){
        int rox = parent[root(x,parent)];
        int roy = parent[root(y,parent)];
        if (rox==roy)   return;
        if (gcd(rox,roy)>g) parent[roy]=rox;
    }
    
    static int root(int x, int[] parent){
        int rox = parent[x];
        if (x==rox)     return x;
        return parent[x]= root(rox,parent);
    }

    static void printArray(String name, int[] arr) {
    	System.out.println(name);
    	for (int x:arr)	System.out.print(x+",");
    }

}
