/**
 * Cracking Coding Interview 
 * ----------------------------
 * Page-73 
 * Q 1.1 : Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures? 
 * Sol:
 * 		Check if ASCII or Unicode [ASCII has 256 chars, Unicode has 2^21]
 * 		Create a boolean Array of above size(ASCII/Unicode), read each character, 
 * 		check the value (True/False) at corresponding ascii index. 
 * 		If visited(True), return saying not Unique, if not visited(False), mark it as visited(True).
 * 		If String length is greater than 256, return not unique as anything greater than 256 means repetition.
 * 
 * @author Saurav
 */

public class CheckUniqueString {
	public boolean CheckUnique(String str) {
		if (str.length() > 256) return false;

	boolean [] ascii_charset = new boolean[256];
	for (int i=0; i< str.length(); i++){
//		int val = str.charAt(i);
		if (ascii_charset[str.charAt(i)]) { // Already visited
			return false;
		}
			 ascii_charset[str.charAt(i)] = true;
	}
	 return true;
	}
	
	public static void main(String [] args) {
		CheckUniqueString CUS = new CheckUniqueString();
		String str = "hsfjksadhgiuasdfbaskldcfgasdfbjasdff";
		String str1 = "qwertyuiopasdfghjklzxcvbnm)(*&^%$#@ASDFGHJUYTREWQMKLOIP";
		System.out.println("Is String " + str + "' unique? : " + Boolean.toString(CUS.CheckUnique(str)));
		System.out.println("Is String '" + str1 + "' unique? : " + Boolean.toString(CUS.CheckUnique(str1)));
	}
	
}

//	Time Complexity : O(n) = One loop with max N array access.
//	Space Complexity: O(1) = Constant 256
