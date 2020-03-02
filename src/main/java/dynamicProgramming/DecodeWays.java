package dynamicProgramming;

import java.util.Arrays;


/**
 * Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count the number of possible decodings of the given digit sequence.
 * Examples:
 *
 * Input:  digits[] = "121"
 * Output: 3
 * // The possible decodings are "ABA", "AU", "LA"
 *
 * Input: digits[] = "1234"
 * Output: 3
 * // The possible decodings are "ABCD", "LCD", "AWD"
 * An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and there are no leading 0’s, no extra trailing 0’s and no two or more consecutive 0’s.
 */

public class DecodeWays {

	int [] decodeValues;

	public DecodeWays(String s){
		decodeValues = new int[s.length()+1];
		Arrays.fill(decodeValues,-1);
	}

 public int decode(String s, int currIdx){
	 if (currIdx >= s.length()) {
		 return 1; // "" is a valid decomposition
	 }

		if(decodeValues[currIdx]!= -1){
			return decodeValues[currIdx];
		}

		int count=0;

		for (int i=1; i<=2;i++ ) {
			if (currIdx + i <= s.length()) {
				String snippet = s.substring(currIdx, currIdx + i);

				if (isValid(snippet)) {
					count += decode(s, currIdx + i);
				}
			}
		}
	 return decodeValues[currIdx] = count;
 }

 private boolean isValid(String s){
	 if (s.charAt(0)=='0' || s.length()==0)
	 	return false;

 	int strToInt = Integer.parseInt(s);
 	return (strToInt>0 && strToInt<27);
 }

 public static void main(String [] a){
 	 String decodeString = "1234";
	 DecodeWays d = new DecodeWays(decodeString);
	 System.out.println(d.decode(decodeString,0));
 }

}
