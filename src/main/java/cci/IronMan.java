package cci;

/**
 * 
 * @author Saurav
 * 
 * cci.IronMan is ready for battle! He starts his battle at location0 moves in 1-unit increments toward his final showdown at
	location n−1. Each location i has a power value, p . If p < 0, then there is an enemy at location i that he must losep power to
	beat; if p ≥ 0, then he will restorep power at locationi. cci.IronMan dies if his armor charge becomes < 1 at any point either during
	or after a fight, so he needs a proper initial charge to survive all possible fights in his battle traveling from location 0 to location
	n−1. Help him find the minimum charge needed to survive all fights in the battle!
	
	Complete the ironMan function in your editor. It has 1 parameter: an array of n integers, p, where each index i (0 ≤ i < n) 
	describes the power charge lost or gained at battle location i. If the value at some p < 0, it represents the amount of charge cci.IronMan must
	deplete to defeat the enemy; otherwise, it represents the amount of charge that he can restore at that location. 
	Your function must return an integer denoting the minimum starting charge cci.IronMan needs to survive all fights.


	Constraints
	==============
	1 ≤ n ≤ 105
	−100 ≤ pi ≤ 100
	
	Output Format
	================
	Your function must return an integer denoting the minimum amount of charge cci.IronMan will need to survive all fights in the
	battle. This is printed to stdout by the locked stub code in your editor.
	
	Sample Input 0
	===============
	The following argument is passed to your function:p = {-5, 4, -2,3, 1, -1, -6, -1, 0, 5}
	
	Sample output 0
	================
	8
	
	Sample Input 1
	=================
	The following argument is passed to your function: p = {−5,4,−2, 3, 1}
	
	Sample output 1
	================
	6
	
	Sample Input 2
	=================
	The following argument is passed to your function: p = {−5, 4,−2, 3, 1, −1, −6, −1, 0, −5}
	
	Sample Output 2
	================
	13
	
	Explanation
	============
	Sample Case 0:	
	--------------
	If cci.IronMan's initial charge < 8, then he will die somewhere in the middle of his battle. Thus, we return 8 as the minimum charge
	needed to survive the battle.
	
 *
 */
public class IronMan {

	public static void main(String[] args) {
		int[] in0 = {-5, 4, -2,3, 1, -1, -6, -1, 0, 5};
//		int[] in = {−5, 4, −2, 3, 1};
//		int[] othr = {−5, 4,−2, 3, 1, −1, −6, −1, 0, −5};
		
		System.out.println("Expected: 8, Calculated: "+ ironMan(in0));

	}
	
	static int ironMan(int[] p) {
        int min=1;
        int sum=0;
        
        for (int i: p){
            sum=sum +i;
            if (sum <0 && min< Math.abs(sum)) min = Math.abs(sum)+1;
        }
        return min;
    }

}
