package interviewCake;

import java.util.*;


public class StringPermutation {

	/**
	 * Works well for Duplicate strings =>
	 * Final output number => N!/(n1! n2!)
	 * 	where N = length of input string
	 * 				n1 = number of time character of 1st type is repeated
	 * 			  n2 = number of time character of 2nd type is repeated, and so on
	 *
	 * @param inputString
	 * @return
	 */
	public static Set<String> getPermutationsRecursive(String inputString) {

		// handle input string
		if(inputString==null)
			throw new IllegalArgumentException("InputString is null");

		if (inputString.length()<=1)
			return new HashSet<>(Collections.singletonList(inputString));

		// Create map of all character count
		Map<Character, Integer> charCount = new TreeMap<>(); // Maintain Order

		for(char c: inputString.toCharArray()){
			charCount.compute(c,(k,v) -> (v==null)? 1: v+1);
		}

		// Create arrays for character and count mapping => This will be used for recursion
		int index=0;
		char[] str = new char[charCount.size()];
		int[] count = new int[charCount.size()];

		for(Map.Entry<Character,Integer> entry: charCount.entrySet()){
			str[index]=entry.getKey();
			count[index]=entry.getValue();
			index++;
		}

		// Final return set
		Set<String> permutations = new HashSet<>();
		char[] result = new char[inputString.length()];

		getPermutations(str, count, permutations, result, 0);

		return permutations;
	}

	/**
	 * Recursive method to find all permutations of string
	 * @param str
	 * @param count
	 * @param permutations
	 * @param result
	 * @param level
	 */
	private static void getPermutations(char[] str, int[] count,
																			Set<String> permutations, char[] result, int level  ) {

		// Break condition
		if (level == result.length){
			permutations.add(new String(result));
			return;
		}

		for(int i=0;i<result.length;i++){
			if(count[i]==0){
				continue;
			}

			result[level] = str[i];
			count[i]--;
			getPermutations(str, count, permutations, result, level+1);
			//Recursion Coming back, the count should be reinstated
			count[i]++;
		}
	}

	/**
	 * Another method of solving where you take character by character and inset to all positions
	 * @param inputString
	 * @return
	 */
	public static Set<String> getPermutationsWithLast(String inputString) {

		// handle input string
		if(inputString==null)
			throw new IllegalArgumentException("InputString is null");

		if (inputString.length()<=1)
			return new HashSet<>(Collections.singletonList(inputString));

		char lastCharOfString = inputString.charAt(inputString.length()-1);
		String stringExceptLastChar = inputString.substring(0, inputString.length()-1);

		Set<String> allPermutationsExceptLastString = getPermutations(stringExceptLastChar);

		Set<String> allPermutations = new HashSet<>();
		for (String str: allPermutationsExceptLastString){
			for(int position=0; position<=stringExceptLastChar.length();position++){
				// e.g cats => add s to cat => [s + cat, c + s + at,  ca + s + t, cat + s]
				String permutation = str.substring(0,position) + lastCharOfString + str.substring(position);
				allPermutations.add(permutation);
			}
		}
		return allPermutations;
	}

	/**
	 * With first string cut
	 * @param inputString
	 * @return
	 */
	public static Set<String> getPermutations(String inputString) {

		// handle input string
		if(inputString==null)
			throw new IllegalArgumentException("InputString is null");

		if (inputString.length()<=1)
			return new HashSet<>(Collections.singletonList(inputString));


		char firstCharOfString = inputString.charAt(0);
		String stringExceptFirstChar = inputString.substring(1);

		Set<String> allPermutationsExceptFirstString = getPermutations(stringExceptFirstChar);

		Set<String> allPermutations = new HashSet<>();
		for (String str: allPermutationsExceptFirstString){
			for(int position=0; position<=stringExceptFirstChar.length();position++){
				// e.g cats => add s to cat => [s + cat, c + s + at,  ca + s + t, cat + s]
				String permutation = str.substring(0,position) + firstCharOfString + str.substring(position);
				allPermutations.add(permutation);
			}
		}
		return allPermutations;
	}

}
