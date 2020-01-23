package interviewCake;

import java.util.HashSet;
import java.util.Set;

public class IsPermutationPalindrome {
	/**
	 * Write an efficient method that checks whether any permutation ↴ of an input string is a palindrome.
	 *
	 * You can assume the input string only contains lowercase letters.
	 *
	 * Examples:
	 *
	 * "civic" should return true
	 * "ivicc" should return true
	 * "civil" should return false
	 * "livci" should return false
	 *
	 *
	 * "But 'ivicc' isn't a palindrome!"
	 * If you had this thought, read the question again carefully.
	 * We're asking if any permutation of the string is a palindrome.
	 * @param theString
	 * @return
	 */


	public static boolean hasPalindromePermutation(String theString) {

		// check if any permutation of the input is a palindrome

		// For any permutation to be palindrome, it should have atmost
		// 1 elements with odd count occurrence

		Set<Character> charSet = new HashSet<>();

		for(char c: theString.toCharArray()){
			if (charSet.contains(c)){
				charSet.remove(c);
			}
			else
				charSet.add(c);
		}
		return (charSet.size()<=1);
	}

}
