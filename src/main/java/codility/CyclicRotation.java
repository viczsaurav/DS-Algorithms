package codility;

/**
 * 
 * A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is 
 * shifted right by one index, and the last element of the array is moved to the first place. 
 * 
 * For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] 
 * i-(size -1) + k
 * i - (4)+3
 * i-1
 * (elements are shifted right by one index and 6 is moved to the first place).

	The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
	
	Write a function:
	===================
	class Solution { public int[] solution(int[] A, int K); }
	
	that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.
	
	For example, given
	====================
	    A = [3, 8, 9, 7, 6]
	    K = 3
	the function should return [9, 7, 6, 3, 8]. Three rotations were made:
	
	    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
	    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
	    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
	
	For another example, given
	============================
	    A = [0, 0, 0]
	    K = 1
	the function should return [0, 0, 0]
	
	Given
	=======
	    A = [1, 2, 3, 4]
	    K = 4
	the function should return [1, 2, 3, 4]
	
	Assume that:
	===============
	N and K are integers within the range [0..100];
	each element of array A is an integer within the range [−1,000..1,000].
	
	In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

 * 
 * @author Saurav
 *
 */
public class CyclicRotation {

	public static void main(String[] args) {
		int[] A = {3, 8, 9, 7, 6}; int k1 = 1;
		int[] B = {3, 8, 9, 7, 6}; int k2 = 3;
		int[] C = {0, 0, 0}; int k3 = 1;
		int[] D = {1, 2, 3, 4}; int k4 = 4;
		
		printArray(solution(A, k1));
		printArray(solution(B, k2));
		printArray(solution(C, k3));
		printArray(solution(D, k4));
		
	}

	public static int[] solution(int[] A, int K) {
		
		if (A.length<2) return A;				// Empty or 1 element
		if (K>= A.length) K = K%A.length;		// K>=N  e.g N=4, K =13
		if (K<1) return A;
       		
	   int[] temp = new int[K];
       
       int i = A.length-1;
       int j= A.length-1;
       int a= 0;
       
       while(K>0) {
    	   temp[a++] = A[i--];
    	   K--;
       }
       while (i>=0) {
    	   A[j--]= A[i--];
       }
       a--; // decreasing last a value
       i=0;	// increasing i
       while(a>=0) {
    	   A[i++] = temp[a--];
       }
       
       return A;
    }
	
	public static int[] juggleSolution(int[] A, int K) {
		
		/**  Instead of moving one by one, divide the array in different sets
		*  where number of sets is equal to GCD of n and d and move the elements within sets. O(n), O(1)
		*/
		int sets = gcd(A.length,K);
		//TODO
		
		return A;
	}
	
	public static int gcd(int a, int b) {
		if(b==0)	return a;
		else 		return gcd(b,a%b);
	}
	
	public static void printArray(int[] A) {
		System.out.println("");
		for (int i : A)	System.out.print(i + ",");
		System.out.println("");
	}
	
}
