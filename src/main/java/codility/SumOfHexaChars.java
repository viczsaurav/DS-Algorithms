package codility;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a method that satisfies the following requirements:
 * •	Takes one string as input.
 * •	Returns one integer.  The returned integer is the sum of all the hexadecimal digits in the input string.
 * Example:  For the input string “12 apples”, the method would return 27, as the string contains the hexadecimal digits (1, 2, a, e) that adds up to decimal 27.   (1 + 2 + 10 + 14 = 27)
 */

	// Loop through string per character
	// digits => sum = sum + digit
	// chars => sum = sum + digit value of chars(a => 10, b=> 11, c=> 12, d=> 13, e=> 14, f=> 14)

public class SumOfHexaChars {

	final static List<Character> hexaCharList =  Arrays.asList('a','b','c','d','e');

	public static int getHexaDecimalSum(String str){
		int sum=0;

		// handle illegal Argument
		if (str==null || str.trim().length()==0){
			return 0;
		}

		for (char ch : str.toLowerCase().toCharArray()){

			// Check if digit
			if (isDigit(ch)){
				sum += Character.getNumericValue(ch);
			}
			else if (isLetter(ch)){
				// Check if it is part of {a= 95, b=96, c, d, e, f} [int(ch) - 85]
				if (hexaCharList.contains(ch)){
					sum = sum + (ch - 87);
				}
			}
		}
		return sum;
	}

	private static boolean isDigit(char ch){
		return Character.isDigit(ch);
	}

	private static boolean isLetter(char ch){
		return Character.isLetter(ch);
	}

	public static void main(String[] args) {
		String str = "12 apples";
		System.out.println(getHexaDecimalSum(str));
	}
}
