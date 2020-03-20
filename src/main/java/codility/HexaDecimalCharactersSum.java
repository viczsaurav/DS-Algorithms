package codility;

import java.util.Arrays;
import java.util.List;

/**
 * Write a method that satisfies the following requirements:
 * •	Takes one string as input.
 * •	Returns one integer.  The returned integer is the sum of all the hexadecimal digits in the input string.
 * Example:  For the input string “12 apples”, the method would return 27, as the string contains the hexadecimal digits (1, 2, a, e) that adds up to decimal 27.   (1 + 2 + 10 + 14 = 27)
 */

public class HexaDecimalCharactersSum {

	private static class HexaDecimalValues{

		private static final List<Integer> integers= Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		private static final List<String> chars = Arrays.asList("a","b","c","d","e","f");

		public static boolean containsInt(int value){
			return integers.contains(value);
		}

		public static boolean containsChar(String value){
			return chars.contains(value);
		}


	}

	public static void main(String[] args) {
		String input ="12 apples";
		System.out.println(getHexaDecimalSum(input));
		System.out.println(getSum(input));
	}

	private static int getHexaDecimalSum(String input){

		if (input==null || input.length()==0){
			return 0;
		}

		int sum=0;

		for (char ch: input.toCharArray()){
			String str = String.valueOf(ch);

			try {
				int i = Integer.parseInt(str);
				if (HexaDecimalValues.containsInt(i)){
					sum += i;
				}
			}
			catch (NumberFormatException e){
				 if (HexaDecimalValues.containsChar(str)){
				 		sum += str.charAt(0)-87;
				 }
			}

		}
		return sum;
	}

	private static int getSum(String input){
		int sum=0;

		if (input==null || input.length()==0){
			return 0;
		}

		for (char ch : input.toLowerCase().toCharArray()){
			if (Character.isDigit(ch)){
				sum+=Integer.parseInt(String.valueOf(ch));
			} else if (ch >= 'a' && ch <='f'){
				sum += ch-87;
			}
		}
		return sum;
	}
}
