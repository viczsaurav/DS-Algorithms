package interviewCake;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordCloud {

	/**
	 * You want to build a word cloud, an infographic where the size of a word corresponds to how often it appears in the body of text.
	 *
	 * To do this, you'll need data. Write code that takes a long string and builds its word cloud data in a hash map ↴ , where the keys are words and the values are the number of times the words occurred.
	 *
	 * Think about capitalized words. For example, look at these sentences:
	 *
	 *   "After beating the eggs, Dana read the next step:"
	 * "Add milk and eggs, then add flour and sugar."
	 * What do we want to do with "After", "Dana", and "add"? In this example, your final hash map should include one "Add" or "add" with a value of 22. Make reasonable (not necessarily perfect) decisions about cases like "After" and "Dana".
	 *
	 * Assume the input will only contain words and standard punctuation.
	 *
	 * You could make a reasonable argument to use regex in your solution. We won't, mainly because performance is difficult to measure and can get pretty bad.
	 *
	 * GOTCHAS
	 * Are you sure your code handles hyphenated words and standard punctuation?
	 * Are you sure your code reasonably handles the same word with different capitalization?
	 *
	 * Try these sentences:
	 *
	 *   "We came, we saw, we conquered...then we ate Bill's (Mille-Feuille) cake."
	 * "The bill came to five dollars."
	 *
	 */

	public static class WordCloudData {

		private Map<String, Integer> wordsToCounts = new HashMap<>();

		private void populateWordsToCounts(String inString) {

			List<Character> punctuation = Arrays.asList(',',':',' ','?','.','!','-');

			StringBuffer word = new StringBuffer();

			for(int i=0; i< inString.length();i++){
				char[] inCharArray = inString.toCharArray();
				if (!punctuation.contains(inCharArray[i])){
					word.append(inCharArray[i]);
				}
				// handling mille-feuille
				else if (i>0 && i<inString.length() &&
								inCharArray[i]=='-' &&
								Character.isLetter(inCharArray[i-1]) &&
								Character.isLetter(inCharArray[i+1])
				) {
					word.append(inCharArray[i]);
				}
				else {
					if (word.toString().trim().length()>0){
						addToHashMap(word.toString().trim());
					}
					word = new StringBuffer();
				}
			}
			// Last add
			if (word.toString().trim().length()>0){
				addToHashMap(word.toString().trim());
			}
		}

		private void addToHashMap(String word){
			if (wordsToCounts.containsKey(word)){
				wordsToCounts.compute(word, (k,v) -> (v==null)? 1: v+1);
			}
			else if (wordsToCounts.containsKey(word.toLowerCase())){
				int cnt = wordsToCounts.get(word.toLowerCase());
				wordsToCounts.put(word.toLowerCase(),++cnt);
			}
			else if (wordsToCounts.containsKey(capitalize(word))){
				int cnt = wordsToCounts.get(capitalize(word));
				wordsToCounts.remove(capitalize(word));
				wordsToCounts.put(word,++cnt);
			}
			else {
				wordsToCounts.put(word,1);
			}
		}

		private static String capitalize(String str){
			return (str.substring(0, 1).toUpperCase() + str.substring(1));
		}
		public WordCloudData(String inputString) {
			populateWordsToCounts(inputString);
		}

		public Map<String, Integer> getWordsToCounts() {
			return wordsToCounts;
		}
	}
}
