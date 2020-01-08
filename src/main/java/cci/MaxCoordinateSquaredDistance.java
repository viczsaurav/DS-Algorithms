package cci;

/**
 * 
 * Give 4 integer points, create co-ordinates while maximizing the distance between them
 * @author Saurav
 *
 */
public class MaxCoordinateSquaredDistance {

	public static void main(String[] args) {
		System.out.println("Expected = 5 , final = "+ solution(1, 1, 2, 3));
		System.out.println("Expected = 8 , final = "+ solution(2, 4, 2, 4));
		System.out.println("Expected = 5 , final = "+ solution(-1, -1, -1, -1));
		System.out.println("Expected = 5 , final = "+ solution(1, 2, 3, 4));
		System.out.println("Expected = 5 , final = "+ solution(1, 1, 2, 3));
		System.out.println("Expected = 5 , final = "+ solution(1, 1, 2, 3));
		System.out.println("Expected =  , final = "+ solution(-10, 0, 0, -10));
		System.out.println("Expected =  , final = "+ solution(-10, 0, 0, 10));
		System.out.println("Expected =  , final = "+ solution(-10, 0, -10, 0));

	}
	
	public static int solution(int A, int B, int C, int D) {
	     int dist=-1;
	     int [] a = {A,B,C,D};
	     
	     for (int i=0;i<4;i++){
	         for (int j=i+1;j<4;j++){
	             if ((i!= 3-j) && (j!=3-i)){
	                int val = findDistance(a[i],a[j],a[4-i-1],a[4-j-1]);
	                if (val>dist)    dist=val;
	             }
	         }
	     }
	     return dist;
	    }
	    public static int findDistance(int x1, int x2, int y1, int y2){
	        return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
	    }

}
